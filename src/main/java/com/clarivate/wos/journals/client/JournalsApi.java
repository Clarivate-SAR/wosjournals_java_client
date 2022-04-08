/*
 * Web of Science™ Journals API
 * This API provides journal-level metadata and metrics for all journals in the Journal Citation Reports™ covered in the Web of Science Core Collection, including the Journal Impact Factor™ and other new metrics. Integrate journal data into your internal systems or retrieve journal indicators for bibliometrics studies.  ## Resources This API follows the REST approach to disclose resources in URL format. Only the GET method is currently available to perform requests over HTTP.  The API is available on the [Clarivate Developer Portal](https://developer.clarivate.com/apis/wos-journal). The access requires registration on the Portal and approval from the Clarivate Sales/Product teams to entitle to the API.  ## Credentials All requests require authentication with an API Key authentication flow. For more details, check the [Guide](https://developer.clarivate.com/help/api-access#key_access).  ## API Client Libraries The current languages/frameworks are supported: [Python](https://github.com/clarivate/wosjournals-python-client) | [Java](https://github.com/clarivate/wosjournals-java-client) | [Javascript](https://github.com/clarivate/wosjournals-javascript-client)  ## Content You can learn more about content at [Journal Citation Reports™ Product page](https://clarivate.com/webofsciencegroup/solutions/journal-citation-reports/), or in the [documentation](http://jcr.help.clarivate.com/Content/home.htm).  ## <a name=\"search\"></a> Search (query parameter `q=`) This API supports free-text search for a journal name, abbreviation, ISSN code, publisher, and Web of Science™ category name (only `/categories` endpoint). You need to provide a complete and valid ISSN code pattern; otherwise, the API will not look up for ISSN codes.  ### Boolean operators | Operator    | Description  | Example| |-----|-----|------------------| | + / \" \" | Search by two or more terms in the same field. Blank space is the same as an AND operator. The search retrieves all the records that contain the terms, e.g., | `/journals?q=matrix biology`<br> `/journals?q=nature+group` | | OR | Search by at least one term in the field. The search retrieves all the records that contain one of the terms, e.g., | `/journals?q=gas OR oil` | | NOT / - | Search by excluding specific terms. The search retrieves all the records that match the query specifics, e.g., | `/journals?q=genetics -nature` |  ### Special symbols The wildcards ( __*__ ) are allowed in the search that starts with the search query&#58; `/journals?q=nano*` will search indications that start from __nano__&#58; for example, _Nanotechnology_ or _nanotubes_.  Please note&#58; the free text search query (with the parameter `q=`) should contain at least three symbols.  ## Filtering The API supports several filters for Journals and Web of Science™ Categories, narrowing down the initial list of entities or search results.  There are two types of filters:  - Filter by one or multiple **values**: *edition*, *categoryCode*, *jcrYear*, *jifQuartile* - Filter by **range**: *jif*, *jifPercentile*, *jci*,   ### Filter by values The filter name goes before the equals sign, followed by one or multiple filter values, separated by a semicolon, like `categoryCode=RZ;RU`. You can combine various filters with or without the search. Filters are separated by an ampersand (**&amp;**): `q=nature&categoryCode=RU;KM&jcrYear=2018`  Please note&#58; filter by *jcrYear* allows only one year value as an input  ### <a name='range'></a> Filter by range The API supports range filtering for Journal Impact Factor (*jif*) or Journal Impact Factor Percentile (*jifPercentile*) with the following operators:  - ***eq*** (equal): if a Journal Impact Factor (Percentile) is equal to a specific number.<br /> For example: for `jif=eq:5.032` the result will include journals with Journal Impact Factor = 5.032.<br /> Not combinable with any other operator - ***gt*** (greater than): if a Journal Impact Factor (Percentile) is greater than a specific number.<br /> For example: for `jif=gt:5` the result will include journals with Journal Impact Factor = 5.001 and higher.<br /> Combinable with *lt* and *lte* operators - ***gte*** (greater than equal): if a Journal Impact Factor (Percentile) is greater than or equal to a specific number.<br /> For example: for `jif=gte:5` the result will include journals with Journal Impact Factor = 5.000 and higher.<br /> Combinable with *lt* and *lte* operators - ***lt*** (less than): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lt:5` the result will include journals with Journal Impact Factor = 4.999 and less.<br /> Combinable with *gt* and *gte* operators - ***lte*** (less than equal): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lte:5` the result will include journals with Journal Impact Factor = 5.000 and less.<br /> Combinable with *gt* and *gte* operators  Use `AND` to combine two operators, e.g.,`jifPercentile=gte:50 AND lte:80` responses with all journals in a percentile range from 50% to 80% (both included).  ## Pagination To ensure fast response time, each search or multiple entity calls (such as `/journals` or `/categories/ID/cited/year/YYYY`) retrieve only a certain number of hits/records.  There are two optional request parameters to browse along with the result&#58; _limit_ and _page_.  - limit&#58; Number of returned results, ranging from 0 to 50 (default **10**) - page&#58; Specifying a page to retrieve (default **1**)  Moreover, this information is shown in the response body, in the tag **metadata**&#58;  ```json \"metadata\": {   \"total\": 91,   \"page\": 1,   \"limit\": 10 } ``` ## Errors The WoS Journals API uses conventional HTTP success or failure status codes. For errors, some extra information is included to indicate what went wrong in the JSON response. The list of HTTP codes is listed below.  | Code  | Title  | Description | |---|---|---| | 400  | Bad request  | Request syntax error | | 401  | Unauthorized  | The API key is invalid or missed | | 404  | Not found  | The resource is not found | | 405 | Method not allowed | Method other than GET is not allowed | | 50X  | Server errors  | Technical error with servers| Each error response (except `401 Unauthorized` error) contains the code of the error, the title of the error and detailed description of the error: a misprint in an endpoint, wrong URL parameter, etc. The example of the error message is shown below:  ```json \"error\": {   \"status\": 404,   \"title\": \"Resource couldn't be found\",   \"details\": \"There is no information in WoS Journals API about the identifier ABC_DEF for the Journals content area. Sorry :(\" } ``` For the `401 Unauthorized` error the response body is a little bit different: ```json {   \"error_description\": \"The access token is missing\",   \"error\": \"invalid_request\" } ```
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.clarivate.wos.journals.client;

import com.clarivate.wos.journals.client.invoker.ApiCallback;
import com.clarivate.wos.journals.client.invoker.ApiClient;
import com.clarivate.wos.journals.client.invoker.ApiException;
import com.clarivate.wos.journals.client.invoker.ApiResponse;
import com.clarivate.wos.journals.client.invoker.Configuration;
import com.clarivate.wos.journals.client.invoker.Pair;
import com.clarivate.wos.journals.client.invoker.ProgressRequestBody;
import com.clarivate.wos.journals.client.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.clarivate.wos.journals.client.model.JournalHistoryRecord;
import com.clarivate.wos.journals.client.model.JournalList;
import com.clarivate.wos.journals.client.model.JournalRecord;
import com.clarivate.wos.journals.client.model.JournalReports;
import com.clarivate.wos.journals.client.model.JournalsCited;
import com.clarivate.wos.journals.client.model.JournalsCiting;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JournalsApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public JournalsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public JournalsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for journalsGet
     * @param q Free-text search by journal name (e.g. *Nature Genetics*), JCR abbreviation (e.g. *NAT GENET*), publisher (e.g. *PUBLIC LIBRARY SCIENCE*) or [ISSN / eISSN code](https://www.issn.org/understanding-the-issn/what-is-an-issn/) (e.g. *1061-4036*)  The search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Science Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded - SSCI - Social Sciences Citation Index - AHCI - Arts &amp; Humanities Citation Index - ESCI - Emerging Sources Citation Index  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param categoryCode Filter journals by category identifiers.  Each journal in JCR is assigned to at least one of the subject categories, indicating a general area of science or the social sciences. Journals may be included in more than one subject category.  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Journal Citation Report year (from 1997).  **NOTE:** The filter **jcrYear** is mandatory while using **jif**, **jifPercentile**, **jifQuartile**, and **jci** filters  Only one value is allowed. (optional)
     * @param jif Filter by [Journal Impact Factor](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JIF).  **NOTE:** The filter **jcrYear** is mandatory while using **jif** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifPercentile Filter by [Journal Impact Factor Percentile](http://jcr.help.clarivate.com/Content/glossary-journal-impact-factor-percentile.htm), ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jifPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifQuartile Filter by JIF quartile rank for a category, from highest to lowest based on their JIF value: &lt;br /&gt;Q1 is represented by the top 25% of journals in the category; &lt;br /&gt;Q2 is occupied by journals in the 25 to 50% group; &lt;br /&gt;Q3 is occupied by journals in the 50 to 75% group; &lt;br /&gt;Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jifQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jci Filter by [Journal Citation Indicator](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JCI).  **NOTE:** The filter **jcrYear** is mandatory while using **jci** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jciQuartile Filter by JCI quartile rank for a category, from highest to lowest based on their JCI value: Q1 is represented by the top 25% of journals in the category; Q2 is occupied by journals in the 25 to 50% group; Q3 is occupied by journals in the 50 to 75% group; Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jciQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jciPercentile Filter by Journal Citation Indicator (JCI) percentile, ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jciPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Journal list is sorted alphabetically when retrieving without or with fitlers only, and by relevance when searching. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsGetCall(String q, String edition, String categoryCode, Integer jcrYear, String jif, String jifPercentile, String jifQuartile, String jci, String jciQuartile, String jciPercentile, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/journals";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (q != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("q", q));
        }

        if (edition != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("edition", edition));
        }

        if (categoryCode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("categoryCode", categoryCode));
        }

        if (jcrYear != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jcrYear", jcrYear));
        }

        if (jif != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jif", jif));
        }

        if (jifPercentile != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jifPercentile", jifPercentile));
        }

        if (jifQuartile != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jifQuartile", jifQuartile));
        }

        if (jci != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jci", jci));
        }

        if (jciQuartile != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jciQuartile", jciQuartile));
        }

        if (jciPercentile != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jciPercentile", jciPercentile));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call journalsGetValidateBeforeCall(String q, String edition, String categoryCode, Integer jcrYear, String jif, String jifPercentile, String jifQuartile, String jci, String jciQuartile, String jciPercentile, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = journalsGetCall(q, edition, categoryCode, jcrYear, jif, jifPercentile, jifQuartile, jci, jciQuartile, jciPercentile, page, limit, _callback);
        return localVarCall;

    }

    /**
     * Search and filter across JCR Journals
     * The endpoint allows to search, filter, or browse across the Journals content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: ISSN or title/publisher search - &#x60;edition&#x60;: filter by journal edition - &#x60;categoryCode&#x60;: filter by WoS journal category - &#x60;jcrYear&#x60;: filter by Journal Citation Report Year (since 1997) - &#x60;jif&#x60;: filter by Journal Impact Factor (JIF) - &#x60;jifPercentile&#x60;: filter by Journal Impact Factor Percentile (0-100) - &#x60;jifQuartile&#x60;: filter by Journal Impact Factor Rank Quartile - &#x60;jci&#x60;: filter by Journal Citation Indicator (JCI) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Journals unique ID (based on JCR abbreviated title) - API Link to Journal record - Journal title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Category information (unique ID, category name, and edition) - only if the parameter &#x60;categoryCode&#x60; or &#x60;edition&#x60; is requested - Link to the Journal Citation Report - only if parameter &#x60;jcrYear&#x60; is requested - Metrics information (Impact metrics) - only if parameter &#x60;jif&#x60; or &#x60;jci&#x60; is requested - Metrics information (Source metrics) - only if parameter &#x60;jifPercentile&#x60; is requested - Ranks information (JIF rank and quartile within the category) - only if parameter &#x60;jifQuartile&#x60; is requested
     * @param q Free-text search by journal name (e.g. *Nature Genetics*), JCR abbreviation (e.g. *NAT GENET*), publisher (e.g. *PUBLIC LIBRARY SCIENCE*) or [ISSN / eISSN code](https://www.issn.org/understanding-the-issn/what-is-an-issn/) (e.g. *1061-4036*)  The search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Science Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded - SSCI - Social Sciences Citation Index - AHCI - Arts &amp; Humanities Citation Index - ESCI - Emerging Sources Citation Index  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param categoryCode Filter journals by category identifiers.  Each journal in JCR is assigned to at least one of the subject categories, indicating a general area of science or the social sciences. Journals may be included in more than one subject category.  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Journal Citation Report year (from 1997).  **NOTE:** The filter **jcrYear** is mandatory while using **jif**, **jifPercentile**, **jifQuartile**, and **jci** filters  Only one value is allowed. (optional)
     * @param jif Filter by [Journal Impact Factor](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JIF).  **NOTE:** The filter **jcrYear** is mandatory while using **jif** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifPercentile Filter by [Journal Impact Factor Percentile](http://jcr.help.clarivate.com/Content/glossary-journal-impact-factor-percentile.htm), ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jifPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifQuartile Filter by JIF quartile rank for a category, from highest to lowest based on their JIF value: &lt;br /&gt;Q1 is represented by the top 25% of journals in the category; &lt;br /&gt;Q2 is occupied by journals in the 25 to 50% group; &lt;br /&gt;Q3 is occupied by journals in the 50 to 75% group; &lt;br /&gt;Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jifQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jci Filter by [Journal Citation Indicator](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JCI).  **NOTE:** The filter **jcrYear** is mandatory while using **jci** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jciQuartile Filter by JCI quartile rank for a category, from highest to lowest based on their JCI value: Q1 is represented by the top 25% of journals in the category; Q2 is occupied by journals in the 25 to 50% group; Q3 is occupied by journals in the 50 to 75% group; Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jciQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jciPercentile Filter by Journal Citation Indicator (JCI) percentile, ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jciPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return JournalList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Journal list is sorted alphabetically when retrieving without or with fitlers only, and by relevance when searching. </td><td>  -  </td></tr>
     </table>
     */
    public JournalList journalsGet(String q, String edition, String categoryCode, Integer jcrYear, String jif, String jifPercentile, String jifQuartile, String jci, String jciQuartile, String jciPercentile, Integer page, Integer limit) throws ApiException {
        ApiResponse<JournalList> localVarResp = journalsGetWithHttpInfo(q, edition, categoryCode, jcrYear, jif, jifPercentile, jifQuartile, jci, jciQuartile, jciPercentile, page, limit);
        return localVarResp.getData();
    }

    /**
     * Search and filter across JCR Journals
     * The endpoint allows to search, filter, or browse across the Journals content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: ISSN or title/publisher search - &#x60;edition&#x60;: filter by journal edition - &#x60;categoryCode&#x60;: filter by WoS journal category - &#x60;jcrYear&#x60;: filter by Journal Citation Report Year (since 1997) - &#x60;jif&#x60;: filter by Journal Impact Factor (JIF) - &#x60;jifPercentile&#x60;: filter by Journal Impact Factor Percentile (0-100) - &#x60;jifQuartile&#x60;: filter by Journal Impact Factor Rank Quartile - &#x60;jci&#x60;: filter by Journal Citation Indicator (JCI) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Journals unique ID (based on JCR abbreviated title) - API Link to Journal record - Journal title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Category information (unique ID, category name, and edition) - only if the parameter &#x60;categoryCode&#x60; or &#x60;edition&#x60; is requested - Link to the Journal Citation Report - only if parameter &#x60;jcrYear&#x60; is requested - Metrics information (Impact metrics) - only if parameter &#x60;jif&#x60; or &#x60;jci&#x60; is requested - Metrics information (Source metrics) - only if parameter &#x60;jifPercentile&#x60; is requested - Ranks information (JIF rank and quartile within the category) - only if parameter &#x60;jifQuartile&#x60; is requested
     * @param q Free-text search by journal name (e.g. *Nature Genetics*), JCR abbreviation (e.g. *NAT GENET*), publisher (e.g. *PUBLIC LIBRARY SCIENCE*) or [ISSN / eISSN code](https://www.issn.org/understanding-the-issn/what-is-an-issn/) (e.g. *1061-4036*)  The search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Science Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded - SSCI - Social Sciences Citation Index - AHCI - Arts &amp; Humanities Citation Index - ESCI - Emerging Sources Citation Index  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param categoryCode Filter journals by category identifiers.  Each journal in JCR is assigned to at least one of the subject categories, indicating a general area of science or the social sciences. Journals may be included in more than one subject category.  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Journal Citation Report year (from 1997).  **NOTE:** The filter **jcrYear** is mandatory while using **jif**, **jifPercentile**, **jifQuartile**, and **jci** filters  Only one value is allowed. (optional)
     * @param jif Filter by [Journal Impact Factor](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JIF).  **NOTE:** The filter **jcrYear** is mandatory while using **jif** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifPercentile Filter by [Journal Impact Factor Percentile](http://jcr.help.clarivate.com/Content/glossary-journal-impact-factor-percentile.htm), ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jifPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifQuartile Filter by JIF quartile rank for a category, from highest to lowest based on their JIF value: &lt;br /&gt;Q1 is represented by the top 25% of journals in the category; &lt;br /&gt;Q2 is occupied by journals in the 25 to 50% group; &lt;br /&gt;Q3 is occupied by journals in the 50 to 75% group; &lt;br /&gt;Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jifQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jci Filter by [Journal Citation Indicator](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JCI).  **NOTE:** The filter **jcrYear** is mandatory while using **jci** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jciQuartile Filter by JCI quartile rank for a category, from highest to lowest based on their JCI value: Q1 is represented by the top 25% of journals in the category; Q2 is occupied by journals in the 25 to 50% group; Q3 is occupied by journals in the 50 to 75% group; Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jciQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jciPercentile Filter by Journal Citation Indicator (JCI) percentile, ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jciPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return ApiResponse&lt;JournalList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Journal list is sorted alphabetically when retrieving without or with fitlers only, and by relevance when searching. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<JournalList> journalsGetWithHttpInfo(String q, String edition, String categoryCode, Integer jcrYear, String jif, String jifPercentile, String jifQuartile, String jci, String jciQuartile, String jciPercentile, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = journalsGetValidateBeforeCall(q, edition, categoryCode, jcrYear, jif, jifPercentile, jifQuartile, jci, jciQuartile, jciPercentile, page, limit, null);
        Type localVarReturnType = new TypeToken<JournalList>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Search and filter across JCR Journals (asynchronously)
     * The endpoint allows to search, filter, or browse across the Journals content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: ISSN or title/publisher search - &#x60;edition&#x60;: filter by journal edition - &#x60;categoryCode&#x60;: filter by WoS journal category - &#x60;jcrYear&#x60;: filter by Journal Citation Report Year (since 1997) - &#x60;jif&#x60;: filter by Journal Impact Factor (JIF) - &#x60;jifPercentile&#x60;: filter by Journal Impact Factor Percentile (0-100) - &#x60;jifQuartile&#x60;: filter by Journal Impact Factor Rank Quartile - &#x60;jci&#x60;: filter by Journal Citation Indicator (JCI) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Journals unique ID (based on JCR abbreviated title) - API Link to Journal record - Journal title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Category information (unique ID, category name, and edition) - only if the parameter &#x60;categoryCode&#x60; or &#x60;edition&#x60; is requested - Link to the Journal Citation Report - only if parameter &#x60;jcrYear&#x60; is requested - Metrics information (Impact metrics) - only if parameter &#x60;jif&#x60; or &#x60;jci&#x60; is requested - Metrics information (Source metrics) - only if parameter &#x60;jifPercentile&#x60; is requested - Ranks information (JIF rank and quartile within the category) - only if parameter &#x60;jifQuartile&#x60; is requested
     * @param q Free-text search by journal name (e.g. *Nature Genetics*), JCR abbreviation (e.g. *NAT GENET*), publisher (e.g. *PUBLIC LIBRARY SCIENCE*) or [ISSN / eISSN code](https://www.issn.org/understanding-the-issn/what-is-an-issn/) (e.g. *1061-4036*)  The search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Science Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded - SSCI - Social Sciences Citation Index - AHCI - Arts &amp; Humanities Citation Index - ESCI - Emerging Sources Citation Index  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param categoryCode Filter journals by category identifiers.  Each journal in JCR is assigned to at least one of the subject categories, indicating a general area of science or the social sciences. Journals may be included in more than one subject category.  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Journal Citation Report year (from 1997).  **NOTE:** The filter **jcrYear** is mandatory while using **jif**, **jifPercentile**, **jifQuartile**, and **jci** filters  Only one value is allowed. (optional)
     * @param jif Filter by [Journal Impact Factor](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JIF).  **NOTE:** The filter **jcrYear** is mandatory while using **jif** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifPercentile Filter by [Journal Impact Factor Percentile](http://jcr.help.clarivate.com/Content/glossary-journal-impact-factor-percentile.htm), ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jifPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jifQuartile Filter by JIF quartile rank for a category, from highest to lowest based on their JIF value: &lt;br /&gt;Q1 is represented by the top 25% of journals in the category; &lt;br /&gt;Q2 is occupied by journals in the 25 to 50% group; &lt;br /&gt;Q3 is occupied by journals in the 50 to 75% group; &lt;br /&gt;Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jifQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jci Filter by [Journal Citation Indicator](http://jcr.help.clarivate.com/Content/jcr3-glossary.htm) (JCI).  **NOTE:** The filter **jcrYear** is mandatory while using **jci** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param jciQuartile Filter by JCI quartile rank for a category, from highest to lowest based on their JCI value: Q1 is represented by the top 25% of journals in the category; Q2 is occupied by journals in the 25 to 50% group; Q3 is occupied by journals in the 50 to 75% group; Q4 is occupied by journals in the 75 to 100% group.  **NOTE:** The filter **jcrYear** is mandatory while using **jciQuartile** filter  Multiple values are allowed, separated by a semicolon ( **;** ) (optional)
     * @param jciPercentile Filter by Journal Citation Indicator (JCI) percentile, ranging from 0 to 100  **NOTE:** The filter **jcrYear** is mandatory while using **jciPercentile** filter  Filter logic is described in the section [Filter by range](#range) (optional)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Journal list is sorted alphabetically when retrieving without or with fitlers only, and by relevance when searching. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsGetAsync(String q, String edition, String categoryCode, Integer jcrYear, String jif, String jifPercentile, String jifQuartile, String jci, String jciQuartile, String jciPercentile, Integer page, Integer limit, final ApiCallback<JournalList> _callback) throws ApiException {

        okhttp3.Call localVarCall = journalsGetValidateBeforeCall(q, edition, categoryCode, jcrYear, jif, jifPercentile, jifQuartile, jci, jciQuartile, jciPercentile, page, limit, _callback);
        Type localVarReturnType = new TypeToken<JournalList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for journalsIdCitedYearYearGet
     * @param id Journal unique identifier (required)
     * @param year Journal Citation Report Year (from 1997) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the cited journal. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdCitedYearYearGetCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/journals/{id}/cited/year/{year}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()))
            .replaceAll("\\{" + "year" + "\\}", localVarApiClient.escapeString(year.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call journalsIdCitedYearYearGetValidateBeforeCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling journalsIdCitedYearYearGet(Async)");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new ApiException("Missing the required parameter 'year' when calling journalsIdCitedYearYearGet(Async)");
        }
        

        okhttp3.Call localVarCall = journalsIdCitedYearYearGetCall(id, year, page, limit, _callback);
        return localVarCall;

    }

    /**
     * Get journals that cite the journal for the JCR year
     * Cited Journal data show how many citations a journal received in the JCR year. Cited journal data is relevant when analyzing metrics such as the Journal Impact Factor and Market Share.  The response contains:  - Citing **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/cited-journal-data.htm)
     * @param id Journal unique identifier (required)
     * @param year Journal Citation Report Year (from 1997) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return JournalsCited
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the cited journal. </td><td>  -  </td></tr>
     </table>
     */
    public JournalsCited journalsIdCitedYearYearGet(String id, Integer year, Integer page, Integer limit) throws ApiException {
        ApiResponse<JournalsCited> localVarResp = journalsIdCitedYearYearGetWithHttpInfo(id, year, page, limit);
        return localVarResp.getData();
    }

    /**
     * Get journals that cite the journal for the JCR year
     * Cited Journal data show how many citations a journal received in the JCR year. Cited journal data is relevant when analyzing metrics such as the Journal Impact Factor and Market Share.  The response contains:  - Citing **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/cited-journal-data.htm)
     * @param id Journal unique identifier (required)
     * @param year Journal Citation Report Year (from 1997) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return ApiResponse&lt;JournalsCited&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the cited journal. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<JournalsCited> journalsIdCitedYearYearGetWithHttpInfo(String id, Integer year, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = journalsIdCitedYearYearGetValidateBeforeCall(id, year, page, limit, null);
        Type localVarReturnType = new TypeToken<JournalsCited>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get journals that cite the journal for the JCR year (asynchronously)
     * Cited Journal data show how many citations a journal received in the JCR year. Cited journal data is relevant when analyzing metrics such as the Journal Impact Factor and Market Share.  The response contains:  - Citing **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/cited-journal-data.htm)
     * @param id Journal unique identifier (required)
     * @param year Journal Citation Report Year (from 1997) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the cited journal. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdCitedYearYearGetAsync(String id, Integer year, Integer page, Integer limit, final ApiCallback<JournalsCited> _callback) throws ApiException {

        okhttp3.Call localVarCall = journalsIdCitedYearYearGetValidateBeforeCall(id, year, page, limit, _callback);
        Type localVarReturnType = new TypeToken<JournalsCited>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for journalsIdCitingYearYearGet
     * @param id An Journal ID (required)
     * @param year A citing Year (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdCitingYearYearGetCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/journals/{id}/citing/year/{year}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()))
            .replaceAll("\\{" + "year" + "\\}", localVarApiClient.escapeString(year.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call journalsIdCitingYearYearGetValidateBeforeCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling journalsIdCitingYearYearGet(Async)");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new ApiException("Missing the required parameter 'year' when calling journalsIdCitingYearYearGet(Async)");
        }
        

        okhttp3.Call localVarCall = journalsIdCitingYearYearGetCall(id, year, page, limit, _callback);
        return localVarCall;

    }

    /**
     * Get journals that were cited by the journal for the JCR year
     * The response contains:  - Cited **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations to the cited journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/citing-journal-data.htm)
     * @param id An Journal ID (required)
     * @param year A citing Year (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return JournalsCiting
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public JournalsCiting journalsIdCitingYearYearGet(String id, Integer year, Integer page, Integer limit) throws ApiException {
        ApiResponse<JournalsCiting> localVarResp = journalsIdCitingYearYearGetWithHttpInfo(id, year, page, limit);
        return localVarResp.getData();
    }

    /**
     * Get journals that were cited by the journal for the JCR year
     * The response contains:  - Cited **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations to the cited journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/citing-journal-data.htm)
     * @param id An Journal ID (required)
     * @param year A citing Year (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return ApiResponse&lt;JournalsCiting&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<JournalsCiting> journalsIdCitingYearYearGetWithHttpInfo(String id, Integer year, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = journalsIdCitingYearYearGetValidateBeforeCall(id, year, page, limit, null);
        Type localVarReturnType = new TypeToken<JournalsCiting>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get journals that were cited by the journal for the JCR year (asynchronously)
     * The response contains:  - Cited **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations to the cited journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/citing-journal-data.htm)
     * @param id An Journal ID (required)
     * @param year A citing Year (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdCitingYearYearGetAsync(String id, Integer year, Integer page, Integer limit, final ApiCallback<JournalsCiting> _callback) throws ApiException {

        okhttp3.Call localVarCall = journalsIdCitingYearYearGetValidateBeforeCall(id, year, page, limit, _callback);
        Type localVarReturnType = new TypeToken<JournalsCiting>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for journalsIdGet
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdGetCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/journals/{id}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call journalsIdGetValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling journalsIdGet(Async)");
        }
        

        okhttp3.Call localVarCall = journalsIdGetCall(id, _callback);
        return localVarCall;

    }

    /**
     * Get journal by id
     * A journal entity contains: - basic bibliographic information about the journal, including publisher, ISSN and e-ISSN (where available), open access status, language, frequency of publication, and Web of Science categorization. - links to the multi-year Journal Citation Report data, starting from 1997.  For more information about Journal inclusion in the index, please visit [this page](http://jcr.help.clarivate.com/Content/scope-notes.htm)
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @return JournalRecord
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public JournalRecord journalsIdGet(String id) throws ApiException {
        ApiResponse<JournalRecord> localVarResp = journalsIdGetWithHttpInfo(id);
        return localVarResp.getData();
    }

    /**
     * Get journal by id
     * A journal entity contains: - basic bibliographic information about the journal, including publisher, ISSN and e-ISSN (where available), open access status, language, frequency of publication, and Web of Science categorization. - links to the multi-year Journal Citation Report data, starting from 1997.  For more information about Journal inclusion in the index, please visit [this page](http://jcr.help.clarivate.com/Content/scope-notes.htm)
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @return ApiResponse&lt;JournalRecord&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<JournalRecord> journalsIdGetWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = journalsIdGetValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<JournalRecord>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get journal by id (asynchronously)
     * A journal entity contains: - basic bibliographic information about the journal, including publisher, ISSN and e-ISSN (where available), open access status, language, frequency of publication, and Web of Science categorization. - links to the multi-year Journal Citation Report data, starting from 1997.  For more information about Journal inclusion in the index, please visit [this page](http://jcr.help.clarivate.com/Content/scope-notes.htm)
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdGetAsync(String id, final ApiCallback<JournalRecord> _callback) throws ApiException {

        okhttp3.Call localVarCall = journalsIdGetValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<JournalRecord>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for journalsIdHistoryGet
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdHistoryGetCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/journals/{id}/history"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call journalsIdHistoryGetValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling journalsIdHistoryGet(Async)");
        }
        

        okhttp3.Call localVarCall = journalsIdHistoryGetCall(id, _callback);
        return localVarCall;

    }

    /**
     * Get journal history by id
     * TBD
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @return JournalHistoryRecord
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public JournalHistoryRecord journalsIdHistoryGet(String id) throws ApiException {
        ApiResponse<JournalHistoryRecord> localVarResp = journalsIdHistoryGetWithHttpInfo(id);
        return localVarResp.getData();
    }

    /**
     * Get journal history by id
     * TBD
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @return ApiResponse&lt;JournalHistoryRecord&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<JournalHistoryRecord> journalsIdHistoryGetWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = journalsIdHistoryGetValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<JournalHistoryRecord>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get journal history by id (asynchronously)
     * TBD
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdHistoryGetAsync(String id, final ApiCallback<JournalHistoryRecord> _callback) throws ApiException {

        okhttp3.Call localVarCall = journalsIdHistoryGetValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<JournalHistoryRecord>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for journalsIdReportsYearYearGet
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param year Journal Citation Report year (jcrYear) (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdReportsYearYearGetCall(String id, Integer year, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/journals/{id}/reports/year/{year}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()))
            .replaceAll("\\{" + "year" + "\\}", localVarApiClient.escapeString(year.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call journalsIdReportsYearYearGetValidateBeforeCall(String id, Integer year, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling journalsIdReportsYearYearGet(Async)");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new ApiException("Missing the required parameter 'year' when calling journalsIdReportsYearYearGet(Async)");
        }
        

        okhttp3.Call localVarCall = journalsIdReportsYearYearGetCall(id, year, _callback);
        return localVarCall;

    }

    /**
     * Get journal metrics for a year
     * This endpoint returns the information about Journal Citation Report by year.  The response contains: - Journal name and link to the Journal entry - Key indications (metrics): impact, source and influence - Journal Impact Factor and ESI citations ranks - Journal Source Data - Three-year content analysis by country/region and organization - Links to the related Cited/Citing reports
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param year Journal Citation Report year (jcrYear) (required)
     * @return JournalReports
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public JournalReports journalsIdReportsYearYearGet(String id, Integer year) throws ApiException {
        ApiResponse<JournalReports> localVarResp = journalsIdReportsYearYearGetWithHttpInfo(id, year);
        return localVarResp.getData();
    }

    /**
     * Get journal metrics for a year
     * This endpoint returns the information about Journal Citation Report by year.  The response contains: - Journal name and link to the Journal entry - Key indications (metrics): impact, source and influence - Journal Impact Factor and ESI citations ranks - Journal Source Data - Three-year content analysis by country/region and organization - Links to the related Cited/Citing reports
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param year Journal Citation Report year (jcrYear) (required)
     * @return ApiResponse&lt;JournalReports&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<JournalReports> journalsIdReportsYearYearGetWithHttpInfo(String id, Integer year) throws ApiException {
        okhttp3.Call localVarCall = journalsIdReportsYearYearGetValidateBeforeCall(id, year, null);
        Type localVarReturnType = new TypeToken<JournalReports>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get journal metrics for a year (asynchronously)
     * This endpoint returns the information about Journal Citation Report by year.  The response contains: - Journal name and link to the Journal entry - Key indications (metrics): impact, source and influence - Journal Impact Factor and ESI citations ranks - Journal Source Data - Three-year content analysis by country/region and organization - Links to the related Cited/Citing reports
     * @param id Journal unique identifier  Currently an identifier is a JCR abbreviation, where blank spaces are substituted with underscores (e.g. *PLOS ONE* Journal has the ID **PLOS_ONE**) (required)
     * @param year Journal Citation Report year (jcrYear) (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call journalsIdReportsYearYearGetAsync(String id, Integer year, final ApiCallback<JournalReports> _callback) throws ApiException {

        okhttp3.Call localVarCall = journalsIdReportsYearYearGetValidateBeforeCall(id, year, _callback);
        Type localVarReturnType = new TypeToken<JournalReports>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
