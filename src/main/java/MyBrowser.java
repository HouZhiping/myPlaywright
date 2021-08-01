import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Proxy;

public class MyBrowser {



    public void createBrowser(){
        System.out.println("程序开始");
        try (Playwright playwright = Playwright.create()) {
            System.out.println("开始创建浏览器");
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setProxy(new Proxy("http://127.0.0.1:7890"));
            launchOptions.setHeadless(false);
            launchOptions.setTimeout(600000).setSlowMo(1000);
            Browser browser = playwright.chromium().launch(launchOptions);
            System.out.println(browser.isConnected());
            Page page = browser.newPage();
            System.out.println(browser.isConnected());
            browser.onDisconnected((a) -> System.out.println("浏览器关闭回调"));
            page.navigate("https://twitter.com/login");
            System.out.println("点击");
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

    public static void main(String[] args) {
        MyBrowser myBrowser = new MyBrowser();
        myBrowser.createBrowser();
    }




}
