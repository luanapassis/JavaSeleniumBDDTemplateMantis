package com.javaCucumber.hooks;

import com.javaCucumber.dbSteps.DataBaseSteps;
import com.javaCucumber.utils.DriverFactory;
import com.javaCucumber.utils.Utils;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class Hooks {

    public static Scenario scenario;
    public static Scenario getScenario() {return scenario; }
    String screenshotdir = System.getProperty("user.dir") + "/test-output/Screenshots/";
    @Before
    public void beforMethodSetUp(Scenario _scenario) throws Throwable {
        //carga da massa de dados
        DataBaseSteps dataBaseSteps = new DataBaseSteps();
        dataBaseSteps.cargaUsuario();
        dataBaseSteps.cargaProjeto();
        dataBaseSteps.cargaMarcadores();

        scenario = _scenario;
        cleanDirectoryReport();
        DriverFactory.createInstance();
        DriverFactory.INSTANCE.manage().window().maximize();
        DriverFactory.INSTANCE.navigate().to("http://localhost/mantis/login_page.php");
    }

    @After
    public void tearDown() throws Exception {
        DriverFactory.quitInstace();
    }

    @AfterStep
    public void attach_screenshot() throws Throwable {
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Utils.getBase64Screenshot(DriverFactory.INSTANCE)); //for html
    }


    public void cleanDirectoryReport() throws Throwable {
        if ((new File(screenshotdir)).exists())
           FileUtils.cleanDirectory(new File(screenshotdir));
    }



}
