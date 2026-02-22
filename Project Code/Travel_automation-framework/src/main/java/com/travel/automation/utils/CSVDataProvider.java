package com.travel.automation.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataProvider {

    /**
     * Reads CSV file and returns Object[][] for TestNG DataProvider
     *
     * @param filePath path to any CSV file
     * @return Object[][] - each row is a test iteration
     */
    public static Object[][] getDataFromCSV(String filePath) {
        List<Object[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                // Skip header row
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                records.add(values);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert List<Object[]> to Object[][]
        Object[][] data = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            data[i] = records.get(i);
        }

        return data;
    }

    /**
     * Generic DataProvider for any CSV file
     * Usage: provide CSV path as argument
     */
    @DataProvider(name = "csvDataProvider")
    public static Object[][] csvDataProvider(org.testng.ITestContext context) {
        // Get CSV file path from test method parameter (optional)
        String filePath = context.getCurrentXmlTest().getParameter("csvFilePath");
        return getDataFromCSV(filePath);
    }
}