package tests.TestNG;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerPractice {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ZipCodeTestWithXML.class);
        logger.info(logger.getName());//"ZipCodeTestWithXML");
        logger.warn("ZipCodeTestWithXML");
    }
}

