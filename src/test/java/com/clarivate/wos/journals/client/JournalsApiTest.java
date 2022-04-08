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

import com.clarivate.wos.journals.client.invoker.ApiException;
import com.clarivate.wos.journals.client.model.JournalHistoryRecord;
import com.clarivate.wos.journals.client.model.JournalList;
import com.clarivate.wos.journals.client.model.JournalRecord;
import com.clarivate.wos.journals.client.model.JournalReports;
import com.clarivate.wos.journals.client.model.JournalsCited;
import com.clarivate.wos.journals.client.model.JournalsCiting;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for JournalsApi
 */
@Ignore
public class JournalsApiTest {

    private final JournalsApi api = new JournalsApi();

    
    /**
     * Search and filter across JCR Journals
     *
     * The endpoint allows to search, filter, or browse across the Journals content.  The endpoint doesn&#39;t require any parameter to return results, although only main information for the first ten records sorted alphabetically will be retrieved.  To get comprehensive results, a set of parameters could be applied: - &#x60;q&#x60;: ISSN or title/publisher search - &#x60;edition&#x60;: filter by journal edition - &#x60;categoryCode&#x60;: filter by WoS journal category - &#x60;jcrYear&#x60;: filter by Journal Citation Report Year (since 1997) - &#x60;jif&#x60;: filter by Journal Impact Factor (JIF) - &#x60;jifPercentile&#x60;: filter by Journal Impact Factor Percentile (0-100) - &#x60;jifQuartile&#x60;: filter by Journal Impact Factor Rank Quartile - &#x60;jci&#x60;: filter by Journal Citation Indicator (JCI) - &#x60;limit&#x60;: set the limit of records on the page (1-50) - &#x60;page&#x60;: set the result page  By default, all the responses are sorted alphabetically, only in case of search the results will be sorted by relevance.  The response contains: - Main information about the number of records found, page and limit - Journals unique ID (based on JCR abbreviated title) - API Link to Journal record - Journal title - Search matches with the found phrase ***&amp;lt;em&amp;gt;*** *highlighted* ***&amp;lt;/em&amp;gt;*** - only if parameter &#x60;q&#x60; is requested - Category information (unique ID, category name, and edition) - only if the parameter &#x60;categoryCode&#x60; or &#x60;edition&#x60; is requested - Link to the Journal Citation Report - only if parameter &#x60;jcrYear&#x60; is requested - Metrics information (Impact metrics) - only if parameter &#x60;jif&#x60; or &#x60;jci&#x60; is requested - Metrics information (Source metrics) - only if parameter &#x60;jifPercentile&#x60; is requested - Ranks information (JIF rank and quartile within the category) - only if parameter &#x60;jifQuartile&#x60; is requested
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journalsGetTest() throws ApiException {
        String q = null;
        String edition = null;
        String categoryCode = null;
        Integer jcrYear = null;
        String jif = null;
        String jifPercentile = null;
        String jifQuartile = null;
        String jci = null;
        String jciQuartile = null;
        String jciPercentile = null;
        Integer page = null;
        Integer limit = null;
                JournalList response = api.journalsGet(q, edition, categoryCode, jcrYear, jif, jifPercentile, jifQuartile, jci, jciQuartile, jciPercentile, page, limit);
        // TODO: test validations
    }
    
    /**
     * Get journals that cite the journal for the JCR year
     *
     * Cited Journal data show how many citations a journal received in the JCR year. Cited journal data is relevant when analyzing metrics such as the Journal Impact Factor and Market Share.  The response contains:  - Citing **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations from the citing journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/cited-journal-data.htm)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journalsIdCitedYearYearGetTest() throws ApiException {
        String id = null;
        Integer year = null;
        Integer page = null;
        Integer limit = null;
                JournalsCited response = api.journalsIdCitedYearYearGet(id, year, page, limit);
        // TODO: test validations
    }
    
    /**
     * Get journals that were cited by the journal for the JCR year
     *
     * The response contains:  - Cited **Journal** with the link to WoS Journal API entity - **Cited Year (all)**:  The total number of citations to the cited journal. This total includes the number shown under each year and the number in the Rest column. - **Cited Year (10 years interval)**: Publication year of the cited articles. - **Cited Year (rest)**: All publication years of cited articles prior to the 10-year period defined by the table. For example, if the cited years shown are 2017-2008, the Rest column will show the number of citations from the citing journal in 2017 to articles published in the cited journal in 2007 and any earlier year.   Please see the detailed infomration in the [JCR Help page](http://jcr.help.clarivate.com/Content/citing-journal-data.htm)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journalsIdCitingYearYearGetTest() throws ApiException {
        String id = null;
        Integer year = null;
        Integer page = null;
        Integer limit = null;
                JournalsCiting response = api.journalsIdCitingYearYearGet(id, year, page, limit);
        // TODO: test validations
    }
    
    /**
     * Get journal by id
     *
     * A journal entity contains: - basic bibliographic information about the journal, including publisher, ISSN and e-ISSN (where available), open access status, language, frequency of publication, and Web of Science categorization. - links to the multi-year Journal Citation Report data, starting from 1997.  For more information about Journal inclusion in the index, please visit [this page](http://jcr.help.clarivate.com/Content/scope-notes.htm)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journalsIdGetTest() throws ApiException {
        String id = null;
                JournalRecord response = api.journalsIdGet(id);
        // TODO: test validations
    }
    
    /**
     * Get journal history by id
     *
     * TBD
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journalsIdHistoryGetTest() throws ApiException {
        String id = null;
                JournalHistoryRecord response = api.journalsIdHistoryGet(id);
        // TODO: test validations
    }
    
    /**
     * Get journal metrics for a year
     *
     * This endpoint returns the information about Journal Citation Report by year.  The response contains: - Journal name and link to the Journal entry - Key indications (metrics): impact, source and influence - Journal Impact Factor and ESI citations ranks - Journal Source Data - Three-year content analysis by country/region and organization - Links to the related Cited/Citing reports
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void journalsIdReportsYearYearGetTest() throws ApiException {
        String id = null;
        Integer year = null;
                JournalReports response = api.journalsIdReportsYearYearGet(id, year);
        // TODO: test validations
    }
    
}
