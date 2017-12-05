import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Usage {

    public static void main(String[] args) {

        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("cucumber.json");
        //jsonFiles.add("cucumber-report-2.json");

        String buildNumber = "1";
        String projectName = "SeleniumWithCucumber";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
// optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);
// addidtional metadata presented on main page
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Firefox");
        configuration.addClassifications("Branch", "release/1.0");

        // optionally add metadata presented on main page via properties file
        //List<String> classificationFiles = new ArrayList<>();
//        classificationFiles.add("properties-1.properties");
//        classificationFiles.add("properties-2.properties");
//        configuration.addClassificationFiles(classificationFiles);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
// and here validate 'result' to decide what to do
// if report has failed features, undefined steps etc
    }
}
