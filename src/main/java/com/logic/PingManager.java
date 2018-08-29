package com.logic;

import com.model.PingAnalyticRequest;
import com.model.PingAnalyticResponse;
import org.apache.commons.lang3.SystemUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.UUID;

public class PingManager {

    private int packets = 10;

    public PingManager() throws Exception {
    }

    public PingManager(int packets) throws Exception {
        if (packets > 0) {
            this.packets = packets;
        }
    }

    public PingAnalyticResponse pingURL(PingAnalyticRequest pingAnalyticRequest) throws Exception {

        if (pingAnalyticRequest == null)
            throw new NullPointerException("ERROR: ping request found NULL.");
        else {

            String url = pingAnalyticRequest.getUrl();
            return processRequest(url);
        }
    }

    private PingAnalyticResponse processRequest(String url) throws Exception {

        String pingOn = "ping -c " + packets + " " + url;

        PingAnalyticResponse pingAnalyticResponse = new PingAnalyticResponse();
        pingAnalyticResponse.setUrl(url);

        Process process = Runtime.getRuntime().exec(pingOn);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String output = new String();
        String line = null;

        while ((line = reader.readLine()) != null) {
            output = output + "\n" + line;
        }

        reader.close();

        if (output.trim().isEmpty())
            throw new Exception("Error: Unable to calculate the latency.");

        
        if (SystemUtils.IS_OS_LINUX) {


            line = output.substring(output.indexOf("rtt") + 3, output.lastIndexOf("ms"));

            String[] data = line.split("=");

            // String[] units = data[0].trim().split("/");
            String[] values = data[1].replaceAll("ms", "").trim().split("/");

            pingAnalyticResponse.setMin(Float.parseFloat(values[0].trim()));
            pingAnalyticResponse.setAvg(Float.parseFloat(values[1].trim()));
            pingAnalyticResponse.setMax(Float.parseFloat(values[2].trim()));
            pingAnalyticResponse.setStddev(Float.parseFloat(values[3].trim()));

            return pingAnalyticResponse;


        } else if (SystemUtils.IS_OS_MAC_OSX) {


            line = output.substring(output.indexOf("round-trip") + 3, output.lastIndexOf("ms"));

            String[] data = line.split("=");

            // String[] units = data[0].trim().split("/");
            String[] values = data[1].replaceAll("ms", "").trim().split("/");

            pingAnalyticResponse.setMin(Float.parseFloat(values[0].trim()));
            pingAnalyticResponse.setAvg(Float.parseFloat(values[1].trim()));
            pingAnalyticResponse.setMax(Float.parseFloat(values[2].trim()));
            pingAnalyticResponse.setStddev(Float.parseFloat(values[3].trim()));

            return pingAnalyticResponse;

        } else {
            throw new Exception("Error: Not supported system type.");
        }


    }
}
