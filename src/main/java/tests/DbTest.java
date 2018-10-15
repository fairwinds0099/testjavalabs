package tests;


import domain.helpers.QueryHandlingHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


// TODO updated
public class DbTest {
    private QueryHandlingHelpers helper = new QueryHandlingHelpers();

        @Test
        public void getId() {
            assertEquals("TX", helper.findAddress("6").getState());

        }
    }

