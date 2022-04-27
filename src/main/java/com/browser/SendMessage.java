package com.browser;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Geolocation;
import com.microsoft.playwright.options.Proxy;

import java.util.ArrayList;
import java.util.List;

public class SendMessage {


    public static void main(String[] args) throws InterruptedException {


        final SendMessage sendMessage = new SendMessage();
        sendMessage.create("https://passport.csdn.net/newlogin?code=mobile", "http://127.0.0.1:7890");


    }



    public void create(String url, String proxy) throws InterruptedException {
        System.out.println("程序开始");
        try (Playwright playwright = Playwright.create()) {
            System.out.println("环境准备完成");
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setProxy(new Proxy(proxy));
            launchOptions.setProxy(new Proxy("socks5://172.16.102.245:3026"));
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

            ElementHandle hrefElement = page.querySelector("input[placeholder='手机号']");
            hrefElement.focus();
            Thread.sleep(2000);
            hrefElement.fill("18583616189");
            Thread.sleep(2000);
            final ElementHandle elementHandle = page.querySelector("text=获取验证码");
            elementHandle.click();

            try {
                Thread.sleep(3000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            browser.close();
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }



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
                Thread.sleep(3000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            browser.close();
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }


}
