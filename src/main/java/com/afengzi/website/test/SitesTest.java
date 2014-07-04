package com.afengzi.website.test;

import com.afengzi.website.domain.CollectionConstant;
import com.afengzi.website.domain.site.Site;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import net.sf.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: lixiuhai
 * Date: 14-7-4
 * Time: ÉÏÎç9:31
 * To change this template use File | Settings | File Templates.
 */
public class SitesTest extends MongoBase {
    private static final String WEBSITE_SITES_COLLECTION = "website.sites";

    public static void main(String[] args){
        SitesTest sites = new SitesTest();
        sites.saveSite();
    }
    public void saveSite(){
        save(getNewSite(2,"JAVA"),WEBSITE_SITES_COLLECTION);
    }

    private DBObject getNewSite(int nodeId,String nodeName){
        Site website = new Site();
        website.set_id(IdUtil.getId(WEBSITE_SITES_COLLECTION));
        website.setNodeId(nodeId);
        website.setTitle("oracle");
        website.setUrl("http://oracle.com");
        website.setUserName(CollectionConstant.WEBSITE_GUEST);
        website.setNodeName(nodeName);

        JSONObject jsonObject = JSONObject.fromObject(website);
        return (DBObject)JSON.parse(jsonObject.toString());
    }


}
