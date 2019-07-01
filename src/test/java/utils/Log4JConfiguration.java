package utils;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "renderer",
        "throwableRenderer",
        "appender",
        "plugin",
        "categoryOrLogger",
        "root",
        "categoryFactoryOrLoggerFactory"
})
@XmlRootElement(name = "log4j:configuration")

public class Log4JConfiguration {
    @XmlAttribute(name = "xmlns:log4j")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlnsLog4J;

    // Other content omitted
}



