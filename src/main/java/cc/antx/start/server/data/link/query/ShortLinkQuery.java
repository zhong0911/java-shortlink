package cc.antx.start.server.data.link.query;

import java.util.Date;

import cc.antx.start.server.data.Database;
import cc.antx.utils.string.StringUtils;

/**
 * @author zhong
 * @date 2023-03-05 12:27
 */
public class ShortLinkQuery {
    public static void main(String[] args) {
        String[] ss = new String[]{"888", "asa"};
        for (String s : ss) {
            System.out.println("ID: " + getId(s));
            System.out.println("Short Link: " + s);
            System.out.println("Long Link: " + getLongLink(s));
            System.out.println("Generation Time: " + getGenerationTime(s));
            System.out.println("ExpirationTime: " + getExpirationTime(s));
            System.out.println("Exists: " + getExists(s));
            System.out.println("Status: " + getStatus(s));
            System.out.println("Code Is Valid: " + getShortLinkValid(s));
            System.out.println("----------------------------------");
        }
        System.out.println(getNewShortLink(6));
        System.out.println(getExists("888H"));
    }


    public static String getId(String shortLink) {
        Object res = Database.executeQuery("SELECT id FROM link WHERE short_link='" + shortLink + "'", "id:int");
        return (res != null) ? String.valueOf(res) : null;
    }

    public static String getLongLink(String shortLink) {
        return (String) Database.executeQuery("SELECT long_link FROM link WHERE short_link='" + shortLink + "'", "long_link:string");
    }

    public static Date getGenerationTime(String shortLink) {
        Object date = Database.executeQuery("SELECT generation_time FROM link WHERE short_link='" + shortLink + "'", "generation_time:datetime");
        return (date != null) ? (Date) date : null;
    }

    public static Date getExpirationTime(String shortLink) {
        Object date = Database.executeQuery("SELECT expiration_time FROM link WHERE short_link='" + shortLink + "'", "expiration_time:datetime");
        return (date != null) ? (Date) date : null;
    }

    public static boolean getStatus(String shortLink) {
        Object res = Database.executeQuery("SELECT status FROM link WHERE short_link='" + shortLink + "'", "status:boolean");
        return res != null && (boolean) res;
    }


    public static boolean getExists(String shortLink) {
        Object res = Database.executeQuery("SELECT short_link FROM link WHERE short_link='" + shortLink + "'", "short_link:string");
        return res != null && res.equals(shortLink);
    }

    public static String getNewShortLink(int length) {
        String shortLink;
        do {
            shortLink = StringUtils.getRandomString(length);
        } while (getExists(shortLink) || shortLink.equals("generate"));
        return shortLink;
    }

    public static String getNewShortLink() {
        return getNewShortLink(6);
    }

    public static Boolean getShortLinkValid(String shortLink) {
        Date res = getExpirationTime(shortLink);
        if (res == null) return false;
        Date now = new Date();
        return now.before(res);
    }
}
