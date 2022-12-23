import cn.nuomi.online.RemoteRegister;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Test {

    /**"mississippi"
        "issip"
     */
    @org.junit.Test
    public void remoteRegist(){
        JSONObject jsonObject = JSONObject.fromObject(new String("{\\\"requestId\\\":\\\"ae1edbe0dccc4161abbfa6ad6982a924\\\",\\\"code\\\":\\\"200\\\",\\\"message\\\":\\\"success\\\",\\\"success\\\":true,\\\"meta\\\":null,\\\"data\\\":{\\\"list\\\":[{\\\"instanceCode\\\":null,\\\"resourceId\\\":\\\"S330782API0220221212000001\\\"}]}}"));
        String resourceId = JSONObject.fromObject(jsonObject)
                .getJSONObject("datas").getJSONObject("data")
                .getJSONObject("list").getJSONObject("resourceId").toString();

        System.out.println(resourceId);
    }
}
