package com.wiley.eb.qe.course;

import com.wiley.eb.qe.base.BaseTest;
import com.wiley.eb.qe.framework.factory.OperationFactory;
import com.wiley.eb.qe.framework.utils.Utility;
import com.wiley.eb.qe.models.person.User;
import com.wiley.eb.qe.ui.operations.pageoperations.LoginOperations;
import com.wiley.eb.qe.ui.testdata.SmokeData;
import data.dataprovider.TestDataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class CreateTestData extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateTestData.class);

    @Test(description = "SmokeData::Create a new course with 200 users ", dataProvider = "getData", dataProviderClass = TestDataProvider.class)
    public void createMailPluginTestData(LinkedHashMap<String, ?> dataProvider) throws Throwable {
        loggingStartReport("Create a new course with 200 users ", "EB-372", "");
        SmokeData testData = Utility.getDataPojo(dataProvider.get("Form"), SmokeData.class);
        User admin = Utility.getDataPojo(dataProvider.get("admin"), User.class);

        LOGGER.info("Login as Admin user");
        OperationFactory.getOperation(LoginOperations.class).doLogin(admin)
                .verifyUserLoggedInSuccessfully()
                .acceptSitePolicy();
    }

}
