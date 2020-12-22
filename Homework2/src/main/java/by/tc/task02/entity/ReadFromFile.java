package by.tc.task02.entity;

import by.tc.task02.entity.criteria.Criteria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    public List<String> readFromFile() throws IOException {
        List<String> appliancesList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(
                    getClass().getResource("/appliances_db.txt").getPath()));
            String stringOfFile;
            while ((stringOfFile = bufferedReader.readLine()) != null) {
                appliancesList.add(stringOfFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        return appliancesList;
    }

    public List<String> readFileByApplianceType(String applianceType) throws IOException {
        List<String> appliancesList = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(
                    getClass().getResource("/appliances_db.txt").getPath()));
            String stringOfFile;
            String[] tempType;
            while ((stringOfFile = bufferedReader.readLine()) != null) {
                tempType = stringOfFile.split(" : ");
                if (tempType[0].equals(applianceType)) {
                    appliancesList.add(stringOfFile);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        return appliancesList;
    }
}
