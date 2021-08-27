import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.Proxy;

import java.util.ArrayList;
import java.util.List;

public class MyBrowser {


//    private final static String twitter = "https://mobile.twitter.com/FrankQin99";
    private final static String kakao = "https://story.kakao.com/";
    private final static String reddit = "https://www.reddit.com/";
    private final static String mixi = "https://mixi.jp";
    private final static String twitter = "https://www.twitter.com";
    private final static String youtube = "https://www.youtube.com/";


    public static void main(String[] args) {
        MyBrowser myBrowser = new MyBrowser();
//        myBrowser.evalOnSelector();
//        myBrowser.loginTwitter();
        myBrowser.createBrowser("https://www.youtube.com", "socks5://127.0.0.1:57103");

    }

    public void createBrowser(String url, String proxy){
        System.out.println("程序开始");
        try (Playwright playwright = Playwright.create()) {
            System.out.println("环境准备完成");
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setProxy(new Proxy(proxy));
//            launchOptions.setProxy(new Proxy("http://127.0.0.1:7890"));
            launchOptions.setHeadless(false);
            launchOptions.setTimeout(600000);
            List<String> args = new ArrayList<>();
            args.add("--lang=en-US");
            launchOptions.setArgs(args);
            Browser browser = playwright.chromium().launch(launchOptions);
//            Browser browser = playwright.webkit().launch(launchOptions);
            System.out.println("创建浏览器完成");
            System.out.println(browser.isConnected());
            BrowserContext browserContext = browser.newContext();
            browserContext.setGeolocation(new Geolocation(38.34, 121.29));
            Page page = browserContext.newPage();
            System.out.println(browser.isConnected());
            browser.onDisconnected((a) -> System.out.println("浏览器关闭回调"));
            page.setDefaultTimeout(100*1000);
            page.navigate(url);
            System.out.println("点击");
            System.out.println(page.title());
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            browser.close();
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }


    public void loginTwitter(){
        try (Playwright playwright = Playwright.create()) {
            System.out.println("环境准备完成");
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setProxy(new Proxy("http://127.0.0.1:7890"));
            launchOptions.setHeadless(false);
            launchOptions.setTimeout(600000).setSlowMo(1000);
            Browser browser = playwright.chromium().launch(launchOptions);
            System.out.println("创建浏览器完成");
            System.out.println(browser.isConnected());
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            System.out.println(browser.isConnected());
            browser.onDisconnected((a) -> System.out.println("浏览器关闭回调"));
            page.navigate("https://twitter.com/login");
            //name="session[username_or_email]"
            page.fill("[name=\"session[username_or_email]\"]", "@RiverHou");
            page.fill("[name=\"session[password]\"]", "Hzp199005023");
            page.click("[data-testid=\"LoginForm_Login_Button\"]");
            System.out.println("登录");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(page.title());
            browser.close();
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }


    public void test(){
        try (Playwright playwright = Playwright.create()) {
            BrowserType webkit = playwright.webkit();
            Browser browser = webkit.launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            context.exposeBinding("pageURL", (source, args) -> source.page().url());
            context.exposeBinding("clicked", (source, args) -> {
                ElementHandle element = (ElementHandle) args[0];
                System.out.println(element.textContent());
                return null;
            }, new BrowserContext.ExposeBindingOptions().setHandle(true));
            Page page = context.newPage();
            page.setContent("" +
                    "<script>\n" +
                    "  document.addEventListener('click', event => window.clicked(event.target));\n" +
                    "</script>\n" +
                    "<div>Click me</div>\n" +
                    "<div>Or click me</div>\n");
//            page.click("button");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void evalOnSelector(){

        try (Playwright playwright = Playwright.create()) {
            System.out.println("环境准备完成");
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setProxy(new Proxy("http://127.0.0.1:7890"));
            launchOptions.setHeadless(false);
            launchOptions.setTimeout(600000);
            Browser browser = playwright.chromium().launch(launchOptions);
            System.out.println("创建浏览器完成");
            System.out.println(browser.isConnected());
            BrowserContext browserContext = browser.newContext();
            browserContext.setGeolocation(new Geolocation(38.34, 121.29));
            Page page = browserContext.newPage();
            System.out.println(browser.isConnected());
            browser.onDisconnected((a) -> System.out.println("浏览器关闭回调"));
            page.navigate(twitter);
            String sectionText = (String) page
                    .evalOnSelector("span.css-901oao.css-16my406.r-poiln3.r-bcqeeo.r-qvutc0", "e => e.textContent");
            //name="session[username_or_email]"
            System.out.println(sectionText);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(page.title());
            browser.close();
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }

    }






}
