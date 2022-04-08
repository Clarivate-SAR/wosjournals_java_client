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

import com.clarivate.wos.wos_journals_client.invoker.ApiException;
import com.clarivate.wos.wos_journals_client.model.CategoriesCited;
import com.clarivate.wos.wos_journals_client.model.CategoriesCiting;
import com.clarivate.wos.wos_journals_client.model.CategoryList;
import com.clarivate.wos.wos_journals_client.model.CategoryRecord;
import com.clarivate.wos.wos_journals_client.model.CategoryReports;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CategoriesApi
 */
@Ignore
public class CategoriesApiTest {

    private final CategoriesApi api = new CategoriesApi();

    
    /**
     * Search and filter across the journal categories
     *
     * The endpoint allows to search, filter, or browse across the Categories content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: Category name - &#x60;edition&#x60;: filter by category edition - &#x60;jcrYear&#x60;: filter by Category Report Year (since 203) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Category unique ID (based on category code and edition) - API Link to Category record - Category title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Edition information - only if the parameter &#x60;edition&#x60; is requested - Link to the Category Report - only if parameter &#x60;jcrYear&#x60; is requested
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void categoriesGetTest() throws ApiException {
        String q = null;
        String edition = null;
        Integer jcrYear = null;
        Integer page = null;
        Integer limit = null;
                CategoryList response = api.categoriesGet(q, edition, jcrYear, page, limit);
        // TODO: test validations
    }
    
    /**
     * Get journals that cite all journals in the category for the JCR year
     *
     * The Cited Subject Category table lists journals that cite other journals in the subject category.  Category Cited data contains:  - Citing **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Citing journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Cited journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/cited-category-data.htm)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void categoriesIdCitedYearYearGetTest() throws ApiException {
        String id = null;
        Integer year = null;
        Integer page = null;
        Integer limit = null;
                CategoriesCited response = api.categoriesIdCitedYearYearGet(id, year, page, limit);
        // TODO: test validations
    }
    
    /**
     * Get journals that were cited by all journals from the category for the JCR year
     *
     * Category Citing data contains:  - Cited **Journal** with the link to WoS Journal API entity.&lt;br /&gt; Cited journals are sorted in descending order. At the top is the journal with the largest number of citations to the subject category. - **Citing journals**: The number of journals in the subject category. - **Cited year (all)**:  The total number of citations to the citing journal. This total includes the number shown under each year and the number in the \&quot;Rest\&quot;. - **Cited Year (10-year interval)**: The publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the ten-year period defined. For example, if the cited years are 2013-2004, the Rest number will show the number of citations from the citing journal in 2012 to articles published in 2003 and earlier in journals in the subject category.     Numbers in the \&quot;All Journals\&quot; are sums of the numbers for each year. \&quot;All others\&quot; refers to citing journals not listed by name.    For detailed information, please visit [this page](http://jcr.help.clarivate.com/Content/citing-category-data.htm)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void categoriesIdCitingYearYearGetTest() throws ApiException {
        String id = null;
        Integer year = null;
        Integer page = null;
        Integer limit = null;
                CategoriesCiting response = api.categoriesIdCitingYearYearGet(id, year, page, limit);
        // TODO: test validations
    }
    
    /**
     * Get a category
     *
     * The category profile provides a comprehensive overview, beginning in 2003, for each of more than 230 different subject categories in the JCR.  Information contain the name, description and links to each JCR Category Year Report (starting from 2003)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void categoriesIdGetTest() throws ApiException {
        String id = null;
                CategoryRecord response = api.categoriesIdGet(id);
        // TODO: test validations
    }
    
    /**
     * Get category metrics for a year
     *
     * For each JCR year all metrics related to a subject category in the Journal Citation Record are available, including: number of journals and articles in the category, Total Cites, Median Impact Factor, Aggregate Impact Factor, Aggregate Immediacy Index, and Cited and Citing category half-life.  Please find detailed information about the metrics in the Journals by JCR Year Report output
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void categoriesIdReportsYearYearGetTest() throws ApiException {
        String id = null;
        Integer year = null;
                CategoryReports response = api.categoriesIdReportsYearYearGet(id, year);
        // TODO: test validations
    }
    
}
