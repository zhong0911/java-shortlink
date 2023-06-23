package cc.antx.start.server.data.link.add;

import cc.antx.start.server.data.Database;

/**
 * @author zhong
 * @date 2023-03-05 13:39
 */
public class ShortLinkAddition {
    public static void main(String[] args) {
        System.out.println(addShortLink("asa", "ass", true, "2222-03-05 12:52:53", "2222-03-05 12:52:53"));
    }

    public static boolean addShortLink(String id, String shortLink, String longLink, boolean status, String generationTime, String expirationTime) {
        return Database.executeSql(String.format("INSERT INTO link VALUES(%s, '%s', '%s', %b, '%s', '%s')", id, shortLink, longLink, status, generationTime, expirationTime));
    }

    public static boolean addShortLink(String shortLink, String longLink, boolean status, String generationTime, String expirationTime) {
        return Database.executeSql(String.format("INSERT INTO link VALUES(DEFAULT, '%s', '%s', %b, '%s', '%s')", shortLink, longLink, status, generationTime, expirationTime));
    }
}
