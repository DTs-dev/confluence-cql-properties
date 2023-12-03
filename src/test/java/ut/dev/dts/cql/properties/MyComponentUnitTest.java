package ut.dev.dts.cql.properties;

import org.junit.Test;
import dev.dts.cql.properties.api.MyPluginComponent;
import dev.dts.cql.properties.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}