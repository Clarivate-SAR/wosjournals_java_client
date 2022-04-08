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


package com.clarivate.wos.journals.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.clarivate.wos.journals.client.model.OpenAccess;
import com.clarivate.wos.journals.client.model.Publisher;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JournalRecord
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-04-08T14:37:40.089+02:00[Europe/Paris]")
public class JournalRecord {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_JCR_TITLE = "jcrTitle";
  @SerializedName(SERIALIZED_NAME_JCR_TITLE)
  private String jcrTitle;

  public static final String SERIALIZED_NAME_ISO_TITLE = "isoTitle";
  @SerializedName(SERIALIZED_NAME_ISO_TITLE)
  private String isoTitle;

  public static final String SERIALIZED_NAME_ISSN = "issn";
  @SerializedName(SERIALIZED_NAME_ISSN)
  private String issn;

  public static final String SERIALIZED_NAME_PREVIOUS_ISSN = "previousIssn";
  @SerializedName(SERIALIZED_NAME_PREVIOUS_ISSN)
  private List<String> previousIssn = null;

  public static final String SERIALIZED_NAME_E_ISSN = "eIssn";
  @SerializedName(SERIALIZED_NAME_E_ISSN)
  private String eIssn;

  public static final String SERIALIZED_NAME_PUBLISHER = "publisher";
  @SerializedName(SERIALIZED_NAME_PUBLISHER)
  private Publisher publisher;

  public static final String SERIALIZED_NAME_FREQUENCY = "frequency";
  @SerializedName(SERIALIZED_NAME_FREQUENCY)
  private Integer frequency;

  public static final String SERIALIZED_NAME_FIRST_ISSUE_YEAR = "firstIssueYear";
  @SerializedName(SERIALIZED_NAME_FIRST_ISSUE_YEAR)
  private Integer firstIssueYear;

  public static final String SERIALIZED_NAME_LANGUAGE = "language";
  @SerializedName(SERIALIZED_NAME_LANGUAGE)
  private String language;

  public static final String SERIALIZED_NAME_OPEN_ACCESS = "openAccess";
  @SerializedName(SERIALIZED_NAME_OPEN_ACCESS)
  private OpenAccess openAccess;

  public static final String SERIALIZED_NAME_CATEGORIES = "categories";
  @SerializedName(SERIALIZED_NAME_CATEGORIES)
  private List<Object> categories = null;

  public static final String SERIALIZED_NAME_JOURNAL_CITATION_REPORTS = "journalCitationReports";
  @SerializedName(SERIALIZED_NAME_JOURNAL_CITATION_REPORTS)
  private List<Object> journalCitationReports = null;

  public JournalRecord() { 
  }

  public JournalRecord id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Journal unique identifier
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Journal unique identifier")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public JournalRecord name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Journal title
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Journal title")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public JournalRecord jcrTitle(String jcrTitle) {
    
    this.jcrTitle = jcrTitle;
    return this;
  }

   /**
   * Journal JCR abbreviation
   * @return jcrTitle
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Journal JCR abbreviation")

  public String getJcrTitle() {
    return jcrTitle;
  }


  public void setJcrTitle(String jcrTitle) {
    this.jcrTitle = jcrTitle;
  }


  public JournalRecord isoTitle(String isoTitle) {
    
    this.isoTitle = isoTitle;
    return this;
  }

   /**
   * Journal title in [ISO format](https://www.issn.org/services/online-services/access-to-the-ltwa/)
   * @return isoTitle
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Journal title in [ISO format](https://www.issn.org/services/online-services/access-to-the-ltwa/)")

  public String getIsoTitle() {
    return isoTitle;
  }


  public void setIsoTitle(String isoTitle) {
    this.isoTitle = isoTitle;
  }


  public JournalRecord issn(String issn) {
    
    this.issn = issn;
    return this;
  }

   /**
   * Current [ISSN identifier](https://www.issn.org/understanding-the-issn/what-is-an-issn/)
   * @return issn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Current [ISSN identifier](https://www.issn.org/understanding-the-issn/what-is-an-issn/)")

  public String getIssn() {
    return issn;
  }


  public void setIssn(String issn) {
    this.issn = issn;
  }


  public JournalRecord previousIssn(List<String> previousIssn) {
    
    this.previousIssn = previousIssn;
    return this;
  }

  public JournalRecord addPreviousIssnItem(String previousIssnItem) {
    if (this.previousIssn == null) {
      this.previousIssn = new ArrayList<String>();
    }
    this.previousIssn.add(previousIssnItem);
    return this;
  }

   /**
   * Previously assignled ISSN identifiers
   * @return previousIssn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Previously assignled ISSN identifiers")

  public List<String> getPreviousIssn() {
    return previousIssn;
  }


  public void setPreviousIssn(List<String> previousIssn) {
    this.previousIssn = previousIssn;
  }


  public JournalRecord eIssn(String eIssn) {
    
    this.eIssn = eIssn;
    return this;
  }

   /**
   * (For online journals) [Electronic ISSN](https://www.issn.org/understanding-the-issn/assignment-rules/the-issn-for-electronic-media/) identifier
   * @return eIssn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "(For online journals) [Electronic ISSN](https://www.issn.org/understanding-the-issn/assignment-rules/the-issn-for-electronic-media/) identifier")

  public String geteIssn() {
    return eIssn;
  }


  public void seteIssn(String eIssn) {
    this.eIssn = eIssn;
  }


  public JournalRecord publisher(Publisher publisher) {
    
    this.publisher = publisher;
    return this;
  }

   /**
   * Get publisher
   * @return publisher
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Publisher getPublisher() {
    return publisher;
  }


  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }


  public JournalRecord frequency(Integer frequency) {
    
    this.frequency = frequency;
    return this;
  }

   /**
   * Number of times per year the journal is published
   * @return frequency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Number of times per year the journal is published")

  public Integer getFrequency() {
    return frequency;
  }


  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }


  public JournalRecord firstIssueYear(Integer firstIssueYear) {
    
    this.firstIssueYear = firstIssueYear;
    return this;
  }

   /**
   * First year the journal was published
   * @return firstIssueYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "First year the journal was published")

  public Integer getFirstIssueYear() {
    return firstIssueYear;
  }


  public void setFirstIssueYear(Integer firstIssueYear) {
    this.firstIssueYear = firstIssueYear;
  }


  public JournalRecord language(String language) {
    
    this.language = language;
    return this;
  }

   /**
   * Journal publication language
   * @return language
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Journal publication language")

  public String getLanguage() {
    return language;
  }


  public void setLanguage(String language) {
    this.language = language;
  }


  public JournalRecord openAccess(OpenAccess openAccess) {
    
    this.openAccess = openAccess;
    return this;
  }

   /**
   * Get openAccess
   * @return openAccess
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public OpenAccess getOpenAccess() {
    return openAccess;
  }


  public void setOpenAccess(OpenAccess openAccess) {
    this.openAccess = openAccess;
  }


  public JournalRecord categories(List<Object> categories) {
    
    this.categories = categories;
    return this;
  }

  public JournalRecord addCategoriesItem(Object categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<Object>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

   /**
   * List of journal categories with related editions/databases
   * @return categories
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of journal categories with related editions/databases")

  public List<Object> getCategories() {
    return categories;
  }


  public void setCategories(List<Object> categories) {
    this.categories = categories;
  }


  public JournalRecord journalCitationReports(List<Object> journalCitationReports) {
    
    this.journalCitationReports = journalCitationReports;
    return this;
  }

  public JournalRecord addJournalCitationReportsItem(Object journalCitationReportsItem) {
    if (this.journalCitationReports == null) {
      this.journalCitationReports = new ArrayList<Object>();
    }
    this.journalCitationReports.add(journalCitationReportsItem);
    return this;
  }

   /**
   * List of all available Journal Citation Reports by year
   * @return journalCitationReports
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of all available Journal Citation Reports by year")

  public List<Object> getJournalCitationReports() {
    return journalCitationReports;
  }


  public void setJournalCitationReports(List<Object> journalCitationReports) {
    this.journalCitationReports = journalCitationReports;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JournalRecord journalRecord = (JournalRecord) o;
    return Objects.equals(this.id, journalRecord.id) &&
        Objects.equals(this.name, journalRecord.name) &&
        Objects.equals(this.jcrTitle, journalRecord.jcrTitle) &&
        Objects.equals(this.isoTitle, journalRecord.isoTitle) &&
        Objects.equals(this.issn, journalRecord.issn) &&
        Objects.equals(this.previousIssn, journalRecord.previousIssn) &&
        Objects.equals(this.eIssn, journalRecord.eIssn) &&
        Objects.equals(this.publisher, journalRecord.publisher) &&
        Objects.equals(this.frequency, journalRecord.frequency) &&
        Objects.equals(this.firstIssueYear, journalRecord.firstIssueYear) &&
        Objects.equals(this.language, journalRecord.language) &&
        Objects.equals(this.openAccess, journalRecord.openAccess) &&
        Objects.equals(this.categories, journalRecord.categories) &&
        Objects.equals(this.journalCitationReports, journalRecord.journalCitationReports);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, jcrTitle, isoTitle, issn, previousIssn, eIssn, publisher, frequency, firstIssueYear, language, openAccess, categories, journalCitationReports);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JournalRecord {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    jcrTitle: ").append(toIndentedString(jcrTitle)).append("\n");
    sb.append("    isoTitle: ").append(toIndentedString(isoTitle)).append("\n");
    sb.append("    issn: ").append(toIndentedString(issn)).append("\n");
    sb.append("    previousIssn: ").append(toIndentedString(previousIssn)).append("\n");
    sb.append("    eIssn: ").append(toIndentedString(eIssn)).append("\n");
    sb.append("    publisher: ").append(toIndentedString(publisher)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    firstIssueYear: ").append(toIndentedString(firstIssueYear)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    openAccess: ").append(toIndentedString(openAccess)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    journalCitationReports: ").append(toIndentedString(journalCitationReports)).append("\n");
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

