package test;

import org.junit.After;
import org.junit.Before;
import test.app.Application;

class BaseRunner {
    Application app;
    @Before
    public void start() {
        app = new Application();
    }
    @After
    public void tearDown() {
        app.quit();
    }
}

