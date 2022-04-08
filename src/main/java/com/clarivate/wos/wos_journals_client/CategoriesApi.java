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


package com.clarivate.wos.wos_journals_client;

import com.clarivate.wos.wos_journals_client.invoker.ApiCallback;
import com.clarivate.wos.wos_journals_client.invoker.ApiClient;
import com.clarivate.wos.wos_journals_client.invoker.ApiException;
import com.clarivate.wos.wos_journals_client.invoker.ApiResponse;
import com.clarivate.wos.wos_journals_client.invoker.Configuration;
import com.clarivate.wos.wos_journals_client.invoker.Pair;
import com.clarivate.wos.wos_journals_client.invoker.ProgressRequestBody;
import com.clarivate.wos.wos_journals_client.invoker.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.clarivate.wos.wos_journals_client.model.CategoriesCited;
import com.clarivate.wos.wos_journals_client.model.CategoriesCiting;
import com.clarivate.wos.wos_journals_client.model.CategoryList;
import com.clarivate.wos.wos_journals_client.model.CategoryRecord;
import com.clarivate.wos.wos_journals_client.model.CategoryReports;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public CategoriesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CategoriesApi(ApiClient apiClient) {
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
     * Build call for categoriesGet
     * @param q Free-text search by category name.  Search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Sceince Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded (ournals across more than 170 disciplines) - SSCI - Social Sciences Citation Index (journals across more than 50 social science disciplines)  Multiple values are allowed, separated by semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Category Citation Report year (from 2003).  Only one value is allowed. (optional)
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
    public okhttp3.Call categoriesGetCall(String q, String edition, Integer jcrYear, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/categories";

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

        if (jcrYear != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("jcrYear", jcrYear));
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
    private okhttp3.Call categoriesGetValidateBeforeCall(String q, String edition, Integer jcrYear, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = categoriesGetCall(q, edition, jcrYear, page, limit, _callback);
        return localVarCall;

    }

    /**
     * Search and filter across the journal categories
     * The endpoint allows to search, filter, or browse across the Categories content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: Category name - &#x60;edition&#x60;: filter by category edition - &#x60;jcrYear&#x60;: filter by Category Report Year (since 203) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Category unique ID (based on category code and edition) - API Link to Category record - Category title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Edition information - only if the parameter &#x60;edition&#x60; is requested - Link to the Category Report - only if parameter &#x60;jcrYear&#x60; is requested
     * @param q Free-text search by category name.  Search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Sceince Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded (ournals across more than 170 disciplines) - SSCI - Social Sciences Citation Index (journals across more than 50 social science disciplines)  Multiple values are allowed, separated by semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Category Citation Report year (from 2003).  Only one value is allowed. (optional)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return CategoryList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CategoryList categoriesGet(String q, String edition, Integer jcrYear, Integer page, Integer limit) throws ApiException {
        ApiResponse<CategoryList> localVarResp = categoriesGetWithHttpInfo(q, edition, jcrYear, page, limit);
        return localVarResp.getData();
    }

    /**
     * Search and filter across the journal categories
     * The endpoint allows to search, filter, or browse across the Categories content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: Category name - &#x60;edition&#x60;: filter by category edition - &#x60;jcrYear&#x60;: filter by Category Report Year (since 203) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Category unique ID (based on category code and edition) - API Link to Category record - Category title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Edition information - only if the parameter &#x60;edition&#x60; is requested - Link to the Category Report - only if parameter &#x60;jcrYear&#x60; is requested
     * @param q Free-text search by category name.  Search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Sceince Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded (ournals across more than 170 disciplines) - SSCI - Social Sciences Citation Index (journals across more than 50 social science disciplines)  Multiple values are allowed, separated by semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Category Citation Report year (from 2003).  Only one value is allowed. (optional)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return ApiResponse&lt;CategoryList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoryList> categoriesGetWithHttpInfo(String q, String edition, Integer jcrYear, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = categoriesGetValidateBeforeCall(q, edition, jcrYear, page, limit, null);
        Type localVarReturnType = new TypeToken<CategoryList>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Search and filter across the journal categories (asynchronously)
     * The endpoint allows to search, filter, or browse across the Categories content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: Category name - &#x60;edition&#x60;: filter by category edition - &#x60;jcrYear&#x60;: filter by Category Report Year (since 203) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Category unique ID (based on category code and edition) - API Link to Category record - Category title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Edition information - only if the parameter &#x60;edition&#x60; is requested - Link to the Category Report - only if parameter &#x60;jcrYear&#x60; is requested
     * @param q Free-text search by category name.  Search logic is described in the section [Search](#search). (optional)
     * @param edition Filter by Web of Sceince Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded (ournals across more than 170 disciplines) - SSCI - Social Sciences Citation Index (journals across more than 50 social science disciplines)  Multiple values are allowed, separated by semicolon ( **;** ) (optional)
     * @param jcrYear Filter by Category Citation Report year (from 2003).  Only one value is allowed. (optional)
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
    public okhttp3.Call categoriesGetAsync(String q, String edition, Integer jcrYear, Integer page, Integer limit, final ApiCallback<CategoryList> _callback) throws ApiException {

        okhttp3.Call localVarCall = categoriesGetValidateBeforeCall(q, edition, jcrYear, page, limit, _callback);
        Type localVarReturnType = new TypeToken<CategoryList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for categoriesIdCitedYearYearGet
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
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
    public okhttp3.Call categoriesIdCitedYearYearGetCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/categories/{id}/cited/year/{year}"
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
    private okhttp3.Call categoriesIdCitedYearYearGetValidateBeforeCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling categoriesIdCitedYearYearGet(Async)");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new ApiException("Missing the required parameter 'year' when calling categoriesIdCitedYearYearGet(Async)");
        }
        

        okhttp3.Call localVarCall = categoriesIdCitedYearYearGetCall(id, year, page, limit, _callback);
        return localVarCall;

    }

    /**
     * Get journals that cite all journals in the category for the JCR year
     * The Cited Subject Category table lists journals that cite other journals in the subject category.  Category Cited data contains:  - Citing **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Cited journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/cited-category-data.htm)
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return CategoriesCited
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CategoriesCited categoriesIdCitedYearYearGet(String id, Integer year, Integer page, Integer limit) throws ApiException {
        ApiResponse<CategoriesCited> localVarResp = categoriesIdCitedYearYearGetWithHttpInfo(id, year, page, limit);
        return localVarResp.getData();
    }

    /**
     * Get journals that cite all journals in the category for the JCR year
     * The Cited Subject Category table lists journals that cite other journals in the subject category.  Category Cited data contains:  - Citing **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Cited journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/cited-category-data.htm)
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return ApiResponse&lt;CategoriesCited&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoriesCited> categoriesIdCitedYearYearGetWithHttpInfo(String id, Integer year, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = categoriesIdCitedYearYearGetValidateBeforeCall(id, year, page, limit, null);
        Type localVarReturnType = new TypeToken<CategoriesCited>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get journals that cite all journals in the category for the JCR year (asynchronously)
     * The Cited Subject Category table lists journals that cite other journals in the subject category.  Category Cited data contains:  - Citing **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Cited journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/cited-category-data.htm)
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
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
    public okhttp3.Call categoriesIdCitedYearYearGetAsync(String id, Integer year, Integer page, Integer limit, final ApiCallback<CategoriesCited> _callback) throws ApiException {

        okhttp3.Call localVarCall = categoriesIdCitedYearYearGetValidateBeforeCall(id, year, page, limit, _callback);
        Type localVarReturnType = new TypeToken<CategoriesCited>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for categoriesIdCitingYearYearGet
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
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
    public okhttp3.Call categoriesIdCitingYearYearGetCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/categories/{id}/citing/year/{year}"
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
    private okhttp3.Call categoriesIdCitingYearYearGetValidateBeforeCall(String id, Integer year, Integer page, Integer limit, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling categoriesIdCitingYearYearGet(Async)");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new ApiException("Missing the required parameter 'year' when calling categoriesIdCitingYearYearGet(Async)");
        }
        

        okhttp3.Call localVarCall = categoriesIdCitingYearYearGetCall(id, year, page, limit, _callback);
        return localVarCall;

    }

    /**
     * Get journals that were cited by all journals from the category for the JCR year
     * Category Citing data contains:  - Cited **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Cited journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Citing journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations to the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/citing-category-data.htm)
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return CategoriesCiting
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CategoriesCiting categoriesIdCitingYearYearGet(String id, Integer year, Integer page, Integer limit) throws ApiException {
        ApiResponse<CategoriesCiting> localVarResp = categoriesIdCitingYearYearGetWithHttpInfo(id, year, page, limit);
        return localVarResp.getData();
    }

    /**
     * Get journals that were cited by all journals from the category for the JCR year
     * Category Citing data contains:  - Cited **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Cited journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Citing journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations to the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/citing-category-data.htm)
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
     * @param page Specifying a page to retrieve (optional, default to 1)
     * @param limit Number of returned results, ranging from 0 to 50 (optional, default to 10)
     * @return ApiResponse&lt;CategoriesCiting&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoriesCiting> categoriesIdCitingYearYearGetWithHttpInfo(String id, Integer year, Integer page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = categoriesIdCitingYearYearGetValidateBeforeCall(id, year, page, limit, null);
        Type localVarReturnType = new TypeToken<CategoriesCiting>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get journals that were cited by all journals from the category for the JCR year (asynchronously)
     * Category Citing data contains:  - Cited **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Cited journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Citing journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations to the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/citing-category-data.htm)
     * @param id Category ID (required)
     * @param year JCR Year (from 2003) (required)
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
    public okhttp3.Call categoriesIdCitingYearYearGetAsync(String id, Integer year, Integer page, Integer limit, final ApiCallback<CategoriesCiting> _callback) throws ApiException {

        okhttp3.Call localVarCall = categoriesIdCitingYearYearGetValidateBeforeCall(id, year, page, limit, _callback);
        Type localVarReturnType = new TypeToken<CategoriesCiting>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for categoriesIdGet
     * @param id Category ID, consisting of a two-letter category code and four-letter edition, separated by **_** (i.e., ***RZ_SSCI*** or ***IP_SCIE***) (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call categoriesIdGetCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/categories/{id}"
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
    private okhttp3.Call categoriesIdGetValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling categoriesIdGet(Async)");
        }
        

        okhttp3.Call localVarCall = categoriesIdGetCall(id, _callback);
        return localVarCall;

    }

    /**
     * Get a category
     * The category profile provides a comprehensive overview, beginning in 2003, for each of more than 230 different subject categories in the JCR.  Information contain the name, description and links to each JCR Category Year Report (starting from 2003)
     * @param id Category ID, consisting of a two-letter category code and four-letter edition, separated by **_** (i.e., ***RZ_SSCI*** or ***IP_SCIE***) (required)
     * @return CategoryRecord
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CategoryRecord categoriesIdGet(String id) throws ApiException {
        ApiResponse<CategoryRecord> localVarResp = categoriesIdGetWithHttpInfo(id);
        return localVarResp.getData();
    }

    /**
     * Get a category
     * The category profile provides a comprehensive overview, beginning in 2003, for each of more than 230 different subject categories in the JCR.  Information contain the name, description and links to each JCR Category Year Report (starting from 2003)
     * @param id Category ID, consisting of a two-letter category code and four-letter edition, separated by **_** (i.e., ***RZ_SSCI*** or ***IP_SCIE***) (required)
     * @return ApiResponse&lt;CategoryRecord&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoryRecord> categoriesIdGetWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = categoriesIdGetValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<CategoryRecord>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get a category (asynchronously)
     * The category profile provides a comprehensive overview, beginning in 2003, for each of more than 230 different subject categories in the JCR.  Information contain the name, description and links to each JCR Category Year Report (starting from 2003)
     * @param id Category ID, consisting of a two-letter category code and four-letter edition, separated by **_** (i.e., ***RZ_SSCI*** or ***IP_SCIE***) (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call categoriesIdGetAsync(String id, final ApiCallback<CategoryRecord> _callback) throws ApiException {

        okhttp3.Call localVarCall = categoriesIdGetValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<CategoryRecord>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for categoriesIdReportsYearYearGet
     * @param id Category ID (required)
     * @param year Category report year (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call categoriesIdReportsYearYearGetCall(String id, Integer year, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/categories/{id}/reports/year/{year}"
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
    private okhttp3.Call categoriesIdReportsYearYearGetValidateBeforeCall(String id, Integer year, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling categoriesIdReportsYearYearGet(Async)");
        }
        
        // verify the required parameter 'year' is set
        if (year == null) {
            throw new ApiException("Missing the required parameter 'year' when calling categoriesIdReportsYearYearGet(Async)");
        }
        

        okhttp3.Call localVarCall = categoriesIdReportsYearYearGetCall(id, year, _callback);
        return localVarCall;

    }

    /**
     * Get category metrics for a year
     * For each JCR year all metrics related to a subject category in the Journal Citation Record are available, including: number of journals and articles in the category, Total Cites, Median Impact Factor, Aggregate Impact Factor, Aggregate Immediacy Index, and Cited and Citing category half-life.  Please find detailed information about the metrics in the Journals by JCR Year Report output
     * @param id Category ID (required)
     * @param year Category report year (required)
     * @return CategoryReports
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public CategoryReports categoriesIdReportsYearYearGet(String id, Integer year) throws ApiException {
        ApiResponse<CategoryReports> localVarResp = categoriesIdReportsYearYearGetWithHttpInfo(id, year);
        return localVarResp.getData();
    }

    /**
     * Get category metrics for a year
     * For each JCR year all metrics related to a subject category in the Journal Citation Record are available, including: number of journals and articles in the category, Total Cites, Median Impact Factor, Aggregate Impact Factor, Aggregate Immediacy Index, and Cited and Citing category half-life.  Please find detailed information about the metrics in the Journals by JCR Year Report output
     * @param id Category ID (required)
     * @param year Category report year (required)
     * @return ApiResponse&lt;CategoryReports&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CategoryReports> categoriesIdReportsYearYearGetWithHttpInfo(String id, Integer year) throws ApiException {
        okhttp3.Call localVarCall = categoriesIdReportsYearYearGetValidateBeforeCall(id, year, null);
        Type localVarReturnType = new TypeToken<CategoryReports>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get category metrics for a year (asynchronously)
     * For each JCR year all metrics related to a subject category in the Journal Citation Record are available, including: number of journals and articles in the category, Total Cites, Median Impact Factor, Aggregate Impact Factor, Aggregate Immediacy Index, and Cited and Citing category half-life.  Please find detailed information about the metrics in the Journals by JCR Year Report output
     * @param id Category ID (required)
     * @param year Category report year (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call categoriesIdReportsYearYearGetAsync(String id, Integer year, final ApiCallback<CategoryReports> _callback) throws ApiException {

        okhttp3.Call localVarCall = categoriesIdReportsYearYearGetValidateBeforeCall(id, year, _callback);
        Type localVarReturnType = new TypeToken<CategoryReports>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
