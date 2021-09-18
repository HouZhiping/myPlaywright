package enume;

public enum Platform {

    facebook("facebook", "https://www.facebook.com", "",""),
    twitter("twitter", "https://www.twitter.com", "",""),
    youtube("youtube", "https://www.youtube.com", "",""),
    instagram("instagram", "https://www.instagram.com", "",""),
    linkedin("linkedin", "https://www.linkedin.com", "",""),
    pinterest("pinterest", "https://www.pinterest.com", "",""),
    ptt("ptt", "https://term.ptt.cc", "",""),
    eyny("eyny", "http://www.eyny.com", "",""),
    yam("yam","http://n.yam.com", "",""),
    pixnet("pixnet","https://www.pixnet.net", "",""),
    hinet("hinet","https://www.hinet.net/", "",""),
    kakao("kakao","https://accounts.kakao.com/login/kakaostory", "",""),
    band("band","https://band.us", "",""),
    tistory("tistory","https://www.tistory.com", "",""),
    mixi("mixi","https://mixi.jp", "",""),
    pixiv("pixiv","https://www.pixiv.net", "",""),
    ameba("ameba","https://www.ameba.jp/", "",""),
    zalo("zalo","https://id.zalo.me", "",""),
    tiktok("tiktok","https://www.tiktok.com", "",""),
    weibo("weibo","https://weibo.com/login.php", "",""),
    reddit("reddit","https://www.reddit.com", "",""),
    hkgolden("hkgolden","https://forum.hkgolden.com", "",""),
    lihkg("lihkg","https://lihkg.com", "",""),
    discuss("discuss","https://www.discuss.com.hk", "","");


    private String name;

    private String url;

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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


    Platform(String name, String url, String username, String password) {
        this.name =name;
        this.url = url;
        this.username = username;
        this.password = password;

    }

}
