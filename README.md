# wos-journals-client

Web of Science™ Journals API
- API version: 1.0.0
  - Build date: 2022-04-08T14:37:40.089+02:00[Europe/Paris]

This API provides journal-level metadata and metrics for all journals in the Journal Citation Reports™ covered in the Web of Science Core Collection, including the Journal Impact Factor™ and other new metrics. Integrate journal data into your internal systems or retrieve journal indicators for bibliometrics studies.

## Resources
This API follows the REST approach to disclose resources in URL format. Only the GET method is currently available to perform requests over HTTP.

The API is available on the [Clarivate Developer Portal](https://developer.clarivate.com/apis/wos-journal). The access requires registration on the Portal and approval from the Clarivate Sales/Product teams to entitle to the API.

## Credentials
All requests require authentication with an API Key authentication flow. For more details, check the [Guide](https://developer.clarivate.com/help/api-access#key_access).

## API Client Libraries
The current languages/frameworks are supported: [Python](https://github.com/clarivate/wosjournals-python-client) | [Java](https://github.com/clarivate/wosjournals-java-client) | [Javascript](https://github.com/clarivate/wosjournals-javascript-client)

## Content
You can learn more about content at [Journal Citation Reports™ Product page](https://clarivate.com/webofsciencegroup/solutions/journal-citation-reports/), or in the [documentation](http://jcr.help.clarivate.com/Content/home.htm).

## <a name=\"search\"></a> Search (query parameter `q=`)
This API supports free-text search for a journal name, abbreviation, ISSN code, publisher, and Web of Science™ category name (only `/categories` endpoint). You need to provide a complete and valid ISSN code pattern; otherwise, the API will not look up for ISSN codes.

### Boolean operators
| Operator    | Description  | Example|
|-----|-----|------------------|
| + / \" \" | Search by two or more terms in the same field. Blank space is the same as an AND operator. The search retrieves all the records that contain the terms, e.g., | `/journals?q=matrix biology`<br> `/journals?q=nature+group` |
| OR | Search by at least one term in the field. The search retrieves all the records that contain one of the terms, e.g., | `/journals?q=gas OR oil` |
| NOT / - | Search by excluding specific terms. The search retrieves all the records that match the query specifics, e.g., | `/journals?q=genetics -nature` |

### Special symbols
The wildcards ( __*__ ) are allowed in the search that starts with the search query&#58; `/journals?q=nano*` will search indications that start from __nano__&#58; for example, _Nanotechnology_ or _nanotubes_.

Please note&#58; the free text search query (with the parameter `q=`) should contain at least three symbols.

## Filtering
The API supports several filters for Journals and Web of Science™ Categories, narrowing down the initial list of entities or search results.

There are two types of filters:

- Filter by one or multiple **values**: *edition*, *categoryCode*, *jcrYear*, *jifQuartile*
- Filter by **range**: *jif*, *jifPercentile*, *jci*, 

### Filter by values
The filter name goes before the equals sign, followed by one or multiple filter values, separated by a semicolon, like `categoryCode=RZ;RU`. You can combine various filters with or without the search. Filters are separated by an ampersand (**&amp;**): `q=nature&categoryCode=RU;KM&jcrYear=2018`

Please note&#58; filter by *jcrYear* allows only one year value as an input

### <a name='range'></a> Filter by range
The API supports range filtering for Journal Impact Factor (*jif*) or Journal Impact Factor Percentile (*jifPercentile*) with the following operators:

- ***eq*** (equal): if a Journal Impact Factor (Percentile) is equal to a specific number.<br /> For example: for `jif=eq:5.032` the result will include journals with Journal Impact Factor = 5.032.<br /> Not combinable with any other operator
- ***gt*** (greater than): if a Journal Impact Factor (Percentile) is greater than a specific number.<br /> For example: for `jif=gt:5` the result will include journals with Journal Impact Factor = 5.001 and higher.<br /> Combinable with *lt* and *lte* operators
- ***gte*** (greater than equal): if a Journal Impact Factor (Percentile) is greater than or equal to a specific number.<br /> For example: for `jif=gte:5` the result will include journals with Journal Impact Factor = 5.000 and higher.<br /> Combinable with *lt* and *lte* operators
- ***lt*** (less than): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lt:5` the result will include journals with Journal Impact Factor = 4.999 and less.<br /> Combinable with *gt* and *gte* operators
- ***lte*** (less than equal): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lte:5` the result will include journals with Journal Impact Factor = 5.000 and less.<br /> Combinable with *gt* and *gte* operators

Use `AND` to combine two operators, e.g.,`jifPercentile=gte:50 AND lte:80` responses with all journals in a percentile range from 50% to 80% (both included).

## Pagination
To ensure fast response time, each search or multiple entity calls (such as `/journals` or `/categories/ID/cited/year/YYYY`) retrieve only a certain number of hits/records.

There are two optional request parameters to browse along with the result&#58; _limit_ and _page_.

- limit&#58; Number of returned results, ranging from 0 to 50 (default **10**)
- page&#58; Specifying a page to retrieve (default **1**)

Moreover, this information is shown in the response body, in the tag **metadata**&#58;

```json
\"metadata\": {
  \"total\": 91,
  \"page\": 1,
  \"limit\": 10
}
```
## Errors
The WoS Journals API uses conventional HTTP success or failure status codes. For errors, some extra information is included to indicate what went wrong in the JSON response. The list of HTTP codes is listed below.

| Code  | Title  | Description |
|---|---|---|
| 400  | Bad request  | Request syntax error |
| 401  | Unauthorized  | The API key is invalid or missed |
| 404  | Not found  | The resource is not found |
| 405 | Method not allowed | Method other than GET is not allowed |
| 50X  | Server errors  | Technical error with servers|
Each error response (except `401 Unauthorized` error) contains the code of the error, the title of the error and detailed description of the error: a misprint in an endpoint, wrong URL parameter, etc. The example of the error message is shown below:

```json
\"error\": {
  \"status\": 404,
  \"title\": \"Resource couldn't be found\",
  \"details\": \"There is no information in WoS Journals API about the identifier ABC_DEF for the Journals content area. Sorry :(\"
}
```
For the `401 Unauthorized` error the response body is a little bit different:
```json
{
  \"error_description\": \"The access token is missing\",
  \"error\": \"invalid_request\"
}
```


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.clarivate.wos</groupId>
  <artifactId>wos-journals-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'wos-journals-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'wos-journals-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "com.clarivate.wos:wos-journals-client:1.0.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/wos-journals-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import com.clarivate.wos.journals.client.invoker.ApiClient;
import com.clarivate.wos.journals.client.invoker.ApiException;
import com.clarivate.wos.journals.client.invoker.Configuration;
import com.clarivate.wos.journals.client.invoker.models.*;
import com.clarivate.wos.journals.client.CategoriesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://wos-journals-snapshot.cortellis.int.clarivate.com");

    CategoriesApi apiInstance = new CategoriesApi(defaultClient);
    String q = "q_example"; // String | Free-text search by category name.  Search logic is described in the section [Search](#search).
    String edition = "edition_example"; // String | Filter by Web of Sceince Citation Index. The following indexes (editions) are presented: - SCIE - Science Citation Index Expanded (ournals across more than 170 disciplines) - SSCI - Social Sciences Citation Index (journals across more than 50 social science disciplines)  Multiple values are allowed, separated by semicolon ( **;** )
    Integer jcrYear = 56; // Integer | Filter by Category Citation Report year (from 2003).  Only one value is allowed.
    Integer page = 1; // Integer | Specifying a page to retrieve
    Integer limit = 10; // Integer | Number of returned results, ranging from 0 to 50
    try {
      CategoryList result = apiInstance.categoriesGet(q, edition, jcrYear, page, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoriesApi#categoriesGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://wos-journals-snapshot.cortellis.int.clarivate.com*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CategoriesApi* | [**categoriesGet**](docs/CategoriesApi.md#categoriesGet) | **GET** /categories | Search and filter across the journal categories
*CategoriesApi* | [**categoriesIdCitedYearYearGet**](docs/CategoriesApi.md#categoriesIdCitedYearYearGet) | **GET** /categories/{id}/cited/year/{year} | Get journals that cite all journals in the category for the JCR year
*CategoriesApi* | [**categoriesIdCitingYearYearGet**](docs/CategoriesApi.md#categoriesIdCitingYearYearGet) | **GET** /categories/{id}/citing/year/{year} | Get journals that were cited by all journals from the category for the JCR year
*CategoriesApi* | [**categoriesIdGet**](docs/CategoriesApi.md#categoriesIdGet) | **GET** /categories/{id} | Get a category
*CategoriesApi* | [**categoriesIdReportsYearYearGet**](docs/CategoriesApi.md#categoriesIdReportsYearYearGet) | **GET** /categories/{id}/reports/year/{year} | Get category metrics for a year
*JournalsApi* | [**journalsGet**](docs/JournalsApi.md#journalsGet) | **GET** /journals | Search and filter across JCR Journals
*JournalsApi* | [**journalsIdCitedYearYearGet**](docs/JournalsApi.md#journalsIdCitedYearYearGet) | **GET** /journals/{id}/cited/year/{year} | Get journals that cite the journal for the JCR year
*JournalsApi* | [**journalsIdCitingYearYearGet**](docs/JournalsApi.md#journalsIdCitingYearYearGet) | **GET** /journals/{id}/citing/year/{year} | Get journals that were cited by the journal for the JCR year
*JournalsApi* | [**journalsIdGet**](docs/JournalsApi.md#journalsIdGet) | **GET** /journals/{id} | Get journal by id
*JournalsApi* | [**journalsIdHistoryGet**](docs/JournalsApi.md#journalsIdHistoryGet) | **GET** /journals/{id}/history | Get journal history by id
*JournalsApi* | [**journalsIdReportsYearYearGet**](docs/JournalsApi.md#journalsIdReportsYearYearGet) | **GET** /journals/{id}/reports/year/{year} | Get journal metrics for a year


## Documentation for Models

 - [CategoriesCited](docs/CategoriesCited.md)
 - [CategoriesCitedHits](docs/CategoriesCitedHits.md)
 - [CategoriesCitedJournal](docs/CategoriesCitedJournal.md)
 - [CategoriesCiting](docs/CategoriesCiting.md)
 - [CategoriesCitingHits](docs/CategoriesCitingHits.md)
 - [CategoriesCitingJournal](docs/CategoriesCitingJournal.md)
 - [CategoryData](docs/CategoryData.md)
 - [CategoryList](docs/CategoryList.md)
 - [CategoryListRecord](docs/CategoryListRecord.md)
 - [CategoryRecord](docs/CategoryRecord.md)
 - [CategoryReports](docs/CategoryReports.md)
 - [CategoryReportsJournals](docs/CategoryReportsJournals.md)
 - [CategoryReportsSourceData](docs/CategoryReportsSourceData.md)
 - [CategoryReportsSourceDataArticles](docs/CategoryReportsSourceDataArticles.md)
 - [CategoryReportsSourceDataReviews](docs/CategoryReportsSourceDataReviews.md)
 - [CitedData](docs/CitedData.md)
 - [CitingData](docs/CitingData.md)
 - [Frequency](docs/Frequency.md)
 - [HalfLife](docs/HalfLife.md)
 - [Immediacy](docs/Immediacy.md)
 - [ImpactMetrics](docs/ImpactMetrics.md)
 - [InfluenceMetrics](docs/InfluenceMetrics.md)
 - [InfluenceMetricsEigenFactor](docs/InfluenceMetricsEigenFactor.md)
 - [Jif](docs/Jif.md)
 - [JifAggregate](docs/JifAggregate.md)
 - [JournalData](docs/JournalData.md)
 - [JournalHistoryRecord](docs/JournalHistoryRecord.md)
 - [JournalHistoryRecordIsoTitle](docs/JournalHistoryRecordIsoTitle.md)
 - [JournalHistoryRecordIssn](docs/JournalHistoryRecordIssn.md)
 - [JournalHistoryRecordName](docs/JournalHistoryRecordName.md)
 - [JournalHistoryRecordPublisher](docs/JournalHistoryRecordPublisher.md)
 - [JournalHistoryRecordPublisher1](docs/JournalHistoryRecordPublisher1.md)
 - [JournalHistoryRecordYear](docs/JournalHistoryRecordYear.md)
 - [JournalHistoryRecordYear1](docs/JournalHistoryRecordYear1.md)
 - [JournalHistoryRecordYear2](docs/JournalHistoryRecordYear2.md)
 - [JournalHistoryRecordYear3](docs/JournalHistoryRecordYear3.md)
 - [JournalList](docs/JournalList.md)
 - [JournalListRecord](docs/JournalListRecord.md)
 - [JournalListRecordJournalCitationReports](docs/JournalListRecordJournalCitationReports.md)
 - [JournalListRecordMetrics](docs/JournalListRecordMetrics.md)
 - [JournalListRecordMetricsImpactMetrics](docs/JournalListRecordMetricsImpactMetrics.md)
 - [JournalListRecordMetricsSourceMetrics](docs/JournalListRecordMetricsSourceMetrics.md)
 - [JournalListRecordRanks](docs/JournalListRecordRanks.md)
 - [JournalListRecordRanksJci](docs/JournalListRecordRanksJci.md)
 - [JournalListRecordRanksJif](docs/JournalListRecordRanksJif.md)
 - [JournalProfile](docs/JournalProfile.md)
 - [JournalProfileCitableItems](docs/JournalProfileCitableItems.md)
 - [JournalProfileCitations](docs/JournalProfileCitations.md)
 - [JournalProfileOccurrenceCountries](docs/JournalProfileOccurrenceCountries.md)
 - [JournalProfileOccurrenceOrganizations](docs/JournalProfileOccurrenceOrganizations.md)
 - [JournalRecord](docs/JournalRecord.md)
 - [JournalReports](docs/JournalReports.md)
 - [JournalReportsJournal](docs/JournalReportsJournal.md)
 - [JournalReportsMetrics](docs/JournalReportsMetrics.md)
 - [JournalsCited](docs/JournalsCited.md)
 - [JournalsCitedHits](docs/JournalsCitedHits.md)
 - [JournalsCitesJournal](docs/JournalsCitesJournal.md)
 - [JournalsCiting](docs/JournalsCiting.md)
 - [JournalsCitingHits](docs/JournalsCitingHits.md)
 - [Metadata](docs/Metadata.md)
 - [OpenAccess](docs/OpenAccess.md)
 - [Publisher](docs/Publisher.md)
 - [RankQuartileData](docs/RankQuartileData.md)
 - [Ranks](docs/Ranks.md)
 - [RanksEsiCitations](docs/RanksEsiCitations.md)
 - [RanksJif](docs/RanksJif.md)
 - [SearchMatch](docs/SearchMatch.md)
 - [SourceData](docs/SourceData.md)
 - [SourceDataArticles](docs/SourceDataArticles.md)
 - [SourceMetrics](docs/SourceMetrics.md)
 - [SourceMetricsCitableItems](docs/SourceMetricsCitableItems.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



