package io.github.dnivra26.go.task.hockey;

import com.google.gson.GsonBuilder;
import com.thoughtworks.go.plugin.api.GoApplicationAccessor;
import com.thoughtworks.go.plugin.api.GoPlugin;
import com.thoughtworks.go.plugin.api.GoPluginIdentifier;
import com.thoughtworks.go.plugin.api.exceptions.UnhandledRequestTypeException;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by arvindt on 4/18/15.
 */
public class HockeyTask implements GoPlugin{
    @Override
    public void initializeGoApplicationAccessor(GoApplicationAccessor goApplicationAccessor) {

    }

    @Override
    public GoPluginApiResponse handle(GoPluginApiRequest goPluginApiRequest) throws UnhandledRequestTypeException {
        if("configuration".equals(goPluginApiRequest.requestName())){
            return buildTaskConfiguration();
        }
        else if ("view".equals(goPluginApiRequest.requestName())) {
            return buildTaskTemplate();
        }
        else if ("validate".equals(goPluginApiRequest.requestName())) {
            return validateRequest(goPluginApiRequest);
        }
        else if ("execute".equals(goPluginApiRequest.requestName())) {
            return executeRequest(goPluginApiRequest);
        }
        return null;
    }

    private GoPluginApiResponse executeRequest(GoPluginApiRequest goPluginApiRequest) {
        return null;
    }

    private GoPluginApiResponse validateRequest(GoPluginApiRequest goPluginApiRequest) {
        return null;
    }

    private GoPluginApiResponse buildTaskConfiguration() {
        return null;
    }

    private GoPluginApiResponse buildTaskTemplate() {
       return null;
    }

    private GoPluginApiResponse createResponse(int responseCode, Map body) {
        final DefaultGoPluginApiResponse response = new DefaultGoPluginApiResponse(responseCode);
        response.setResponseBody(new GsonBuilder().serializeNulls().create().toJson(body));
        return response;
    }

    @Override
    public GoPluginIdentifier pluginIdentifier() {
        return new GoPluginIdentifier("task", Arrays.asList("1.0"));
    }
}
