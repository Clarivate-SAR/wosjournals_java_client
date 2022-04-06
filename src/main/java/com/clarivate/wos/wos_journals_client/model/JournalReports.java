/*
 * Web of Science™ Journals API
 * This API provides journal-level metadata and metrics for all journals in the Journal Citation Reports™ covered in the Web of Science Core Collection, including the Journal Impact Factor™ and other new metrics. Integrate journal data into your internal systems or retrieve journal indicators for bibliometrics studies.  ## Resources This API follows the REST approach to disclose resources in URL format. Only the GET method is currently available to perform requests over HTTP.  The API is available on the [Clarivate Developer Portal](https://developer.clarivate.com/apis/wos-journal). The access requires registration on the Portal and approval from the Clarivate Sales/Product teams to entitle to the API.  ## Credentials All requests require authentication with an API Key authentication flow. For more details, check the [Guide](https://developer.clarivate.com/help/api-access#key_access).  ## API Client Libraries The current languages/frameworks are supported: [Python](https://github.com/Clarivate-SAR/wosjournals-py-client) | [Java](https://github.com/Clarivate-SAR/wosjournals_java_client) | [Javascript](https://github.com/Clarivate-SAR/wosjournals_javascript_client)  ## Content You can learn more about content at [Journal Citation Reports™ Product page](https://clarivate.com/webofsciencegroup/solutions/journal-citation-reports/), or in the [documentation](http://jcr.help.clarivate.com/Content/home.htm).  ## <a name=\"search\"></a> Search (query parameter `q=`) This API supports free-text search for a journal name, abbreviation, ISSN code, publisher, and Web of Science™ category name (only `/categories` endpoint). You need to provide a complete and valid ISSN code pattern; otherwise, the API will not look up for ISSN codes.  ### Boolean operators | Operator    | Description  | Example| |-----|-----|------------------| | + / \" \" | Search by two or more terms in the same field. Blank space is the same as an AND operator. The search retrieves all the records that contain the terms, e.g., | `/journals?q=matrix biology`<br> `/journals?q=nature+group` | | OR | Search by at least one term in the field. The search retrieves all the records that contain one of the terms, e.g., | `/journals?q=gas OR oil` | | NOT / - | Search by excluding specific terms. The search retrieves all the records that match the query specifics, e.g., | `/journals?q=genetics -nature` |  ### Special symbols The wildcards ( __*__ ) are allowed in the search that starts with the search query&#58; `/journals?q=nano*` will search indications that start from __nano__&#58; for example, _Nanotechnology_ or _nanotubes_.  Please note&#58; the free text search query (with the parameter `q=`) should contain at least three symbols.  ## Filtering The API supports several filters for Journals and Web of Science™ Categories, narrowing down the initial list of entities or search results.  There are two types of filters:  - Filter by one or multiple **values**: *edition*, *categoryCode*, *jcrYear*, *jifQuartile* - Filter by **range**: *jif*, *jifPercentile*, *jci*,   ### Filter by values The filter name goes before the equals sign, followed by one or multiple filter values, separated by a semicolon, like `categoryCode=RZ;RU`. You can combine various filters with or without the search. Filters are separated by an ampersand (**&amp;**): `q=nature&categoryCode=RU;KM&jcrYear=2018`  Please note&#58; filter by *jcrYear* allows only one year value as an input  ### <a name='range'></a> Filter by range The API supports range filtering for Journal Impact Factor (*jif*) or Journal Impact Factor Percentile (*jifPercentile*) with the following operators:  - ***eq*** (equal): if a Journal Impact Factor (Percentile) is equal to a specific number.<br /> For example: for `jif=eq:5.032` the result will include journals with Journal Impact Factor = 5.032.<br /> Not combinable with any other operator - ***gt*** (greater than): if a Journal Impact Factor (Percentile) is greater than a specific number.<br /> For example: for `jif=gt:5` the result will include journals with Journal Impact Factor = 5.001 and higher.<br /> Combinable with *lt* and *lte* operators - ***gte*** (greater than equal): if a Journal Impact Factor (Percentile) is greater than or equal to a specific number.<br /> For example: for `jif=gte:5` the result will include journals with Journal Impact Factor = 5.000 and higher.<br /> Combinable with *lt* and *lte* operators - ***lt*** (less than): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lt:5` the result will include journals with Journal Impact Factor = 4.999 and less.<br /> Combinable with *gt* and *gte* operators - ***lte*** (less than equal): if a Journal Impact Factor (Percentile) is less than a specific number.<br /> For example: for `jif=lte:5` the result will include journals with Journal Impact Factor = 5.000 and less.<br /> Combinable with *gt* and *gte* operators  Use `AND` to combine two operators, e.g.,`jifPercentile=gte:50 AND lte:80` responses with all journals in a percentile range from 50% to 80% (both included).  ## Pagination To ensure fast response time, each search or multiple entity calls (such as `/journals` or `/categories/ID/cited/year/YYYY`) retrieve only a certain number of hits/records.  There are two optional request parameters to browse along with the result&#58; _limit_ and _page_.  - limit&#58; Number of returned results, ranging from 0 to 50 (default **10**) - page&#58; Specifying a page to retrieve (default **1**)  Moreover, this information is shown in the response body, in the tag **metadata**&#58;  ```json \"metadata\": {   \"total\": 91,   \"page\": 1,   \"limit\": 10 } ``` ## Errors The WoS Journals API uses conventional HTTP success or failure status codes. For errors, some extra information is included to indicate what went wrong in the JSON response. The list of HTTP codes is listed below.  | Code  | Title  | Description | |---|---|---| | 400  | Bad request  | Request syntax error | | 401  | Unauthorized  | The API key is invalid or missed | | 404  | Not found  | The resource is not found | | 405 | Method not allowed | Method other than GET is not allowed | | 50X  | Server errors  | Technical error with servers| Each error response (except `401 Unauthorized` error) contains the code of the error, the title of the error and detailed description of the error: a misprint in an endpoint, wrong URL parameter, etc. The example of the error message is shown below:  ```json \"error\": {   \"status\": 404,   \"title\": \"Resource couldn't be found\",   \"details\": \"There is no information in WoS Journals API about the identifier ABC_DEF for the Journals content area. Sorry :(\" } ``` For the `401 Unauthorized` error the response body is a little bit different: ```json {   \"error_description\": \"The access token is missing\",   \"error\": \"invalid_request\" } ```
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.clarivate.wos.wos_journals_client.model;

import java.util.Objects;
import java.util.Arrays;
import com.clarivate.wos.wos_journals_client.model.JournalData;
import com.clarivate.wos.wos_journals_client.model.JournalProfile;
import com.clarivate.wos.wos_journals_client.model.JournalReportsJournal;
import com.clarivate.wos.wos_journals_client.model.JournalReportsMetrics;
import com.clarivate.wos.wos_journals_client.model.Ranks;
import com.clarivate.wos.wos_journals_client.model.SourceData;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * JournalReports
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-04-06T14:50:48.148+02:00[Europe/Paris]")
public class JournalReports {
  public static final String SERIALIZED_NAME_YEAR = "year";
  @SerializedName(SERIALIZED_NAME_YEAR)
  private Integer year;

  public static final String SERIALIZED_NAME_JOURNAL = "journal";
  @SerializedName(SERIALIZED_NAME_JOURNAL)
  private JournalReportsJournal journal;

  public static final String SERIALIZED_NAME_METRICS = "metrics";
  @SerializedName(SERIALIZED_NAME_METRICS)
  private JournalReportsMetrics metrics;

  public static final String SERIALIZED_NAME_RANKS = "ranks";
  @SerializedName(SERIALIZED_NAME_RANKS)
  private Ranks ranks;

  public static final String SERIALIZED_NAME_JOURNAL_DATA = "journalData";
  @SerializedName(SERIALIZED_NAME_JOURNAL_DATA)
  private JournalData journalData;

  public static final String SERIALIZED_NAME_SOURCE_DATA = "sourceData";
  @SerializedName(SERIALIZED_NAME_SOURCE_DATA)
  private SourceData sourceData;

  public static final String SERIALIZED_NAME_JOURNAL_PROFILE = "journalProfile";
  @SerializedName(SERIALIZED_NAME_JOURNAL_PROFILE)
  private JournalProfile journalProfile;

  public JournalReports() { 
  }

  public JournalReports year(Integer year) {
    
    this.year = year;
    return this;
  }

   /**
   * Report year
   * @return year
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Report year")

  public Integer getYear() {
    return year;
  }


  public void setYear(Integer year) {
    this.year = year;
  }


  public JournalReports journal(JournalReportsJournal journal) {
    
    this.journal = journal;
    return this;
  }

   /**
   * Get journal
   * @return journal
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public JournalReportsJournal getJournal() {
    return journal;
  }


  public void setJournal(JournalReportsJournal journal) {
    this.journal = journal;
  }


  public JournalReports metrics(JournalReportsMetrics metrics) {
    
    this.metrics = metrics;
    return this;
  }

   /**
   * Get metrics
   * @return metrics
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public JournalReportsMetrics getMetrics() {
    return metrics;
  }


  public void setMetrics(JournalReportsMetrics metrics) {
    this.metrics = metrics;
  }


  public JournalReports ranks(Ranks ranks) {
    
    this.ranks = ranks;
    return this;
  }

   /**
   * Get ranks
   * @return ranks
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Ranks getRanks() {
    return ranks;
  }


  public void setRanks(Ranks ranks) {
    this.ranks = ranks;
  }


  public JournalReports journalData(JournalData journalData) {
    
    this.journalData = journalData;
    return this;
  }

   /**
   * Get journalData
   * @return journalData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public JournalData getJournalData() {
    return journalData;
  }


  public void setJournalData(JournalData journalData) {
    this.journalData = journalData;
  }


  public JournalReports sourceData(SourceData sourceData) {
    
    this.sourceData = sourceData;
    return this;
  }

   /**
   * Get sourceData
   * @return sourceData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public SourceData getSourceData() {
    return sourceData;
  }


  public void setSourceData(SourceData sourceData) {
    this.sourceData = sourceData;
  }


  public JournalReports journalProfile(JournalProfile journalProfile) {
    
    this.journalProfile = journalProfile;
    return this;
  }

   /**
   * Get journalProfile
   * @return journalProfile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public JournalProfile getJournalProfile() {
    return journalProfile;
  }


  public void setJournalProfile(JournalProfile journalProfile) {
    this.journalProfile = journalProfile;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JournalReports journalReports = (JournalReports) o;
    return Objects.equals(this.year, journalReports.year) &&
        Objects.equals(this.journal, journalReports.journal) &&
        Objects.equals(this.metrics, journalReports.metrics) &&
        Objects.equals(this.ranks, journalReports.ranks) &&
        Objects.equals(this.journalData, journalReports.journalData) &&
        Objects.equals(this.sourceData, journalReports.sourceData) &&
        Objects.equals(this.journalProfile, journalReports.journalProfile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, journal, metrics, ranks, journalData, sourceData, journalProfile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JournalReports {\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    journal: ").append(toIndentedString(journal)).append("\n");
    sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
    sb.append("    ranks: ").append(toIndentedString(ranks)).append("\n");
    sb.append("    journalData: ").append(toIndentedString(journalData)).append("\n");
    sb.append("    sourceData: ").append(toIndentedString(sourceData)).append("\n");
    sb.append("    journalProfile: ").append(toIndentedString(journalProfile)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

