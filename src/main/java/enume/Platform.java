package enume;

public enum Platform {

    facebook("facebook", "https://www.facebook.com"),
    twitter("twitter", "https://www.twitter.com"),
    youtube("youtube", "https://www.youtube.com"),
    instagram("instagram", "https://www.instagram.com"),
    linkedin("linkedin", "https://www.linkedin.com"),
    pinterest("pinterest", "https://www.pinterest.com"),
    ptt("ptt", "https://term.ptt.cc"),
    eyny("eyny", "http://www.eyny.com"),
    yam("yam","http://n.yam.com"),
    pixnet("pixnet","https://www.pixnet.net"),
    hinet("hinet","https://www.hinet.net/"),
    kakao("kakao","https://accounts.kakao.com/login/kakaostory"),
    band("band","https://band.us"),
    tistory("tistory","https://www.tistory.com"),
    mixi("mixi","https://mixi.jp"),
    pixiv("pixiv","https://www.pixiv.net"),
    ameba("ameba","https://www.ameba.jp/"),
    zalo("zalo","https://id.zalo.me"),
    tiktok("tiktok","https://www.tiktok.com"),
    weibo("weibo","https://weibo.com/login.php"),
    reddit("reddit","https://www.reddit.com"),
    hkgolden("hkgolden","https://forum.hkgolden.com"),
    lihkg("lihkg","https://lihkg.com"),
    discuss("discuss","https://www.discuss.com.hk");


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;


    Platform(String name, String url) {
        this.name =name;
        this.url = url;
    }

}
