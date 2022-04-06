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
import com.clarivate.wos.wos_journals_client.model.JournalProfileCitableItems;
import com.clarivate.wos.wos_journals_client.model.JournalProfileCitations;
import com.clarivate.wos.wos_journals_client.model.JournalProfileOccurrenceCountries;
import com.clarivate.wos.wos_journals_client.model.JournalProfileOccurrenceOrganizations;
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
 * Journal Profile uses JCR year source data, and the two prior years to develop a picture of the countries, regions, and organizations that have published materials in this journal in the past three years.
 */
@ApiModel(description = "Journal Profile uses JCR year source data, and the two prior years to develop a picture of the countries, regions, and organizations that have published materials in this journal in the past three years.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-04-06T14:50:48.148+02:00[Europe/Paris]")
public class JournalProfile {
  public static final String SERIALIZED_NAME_START_YEAR = "startYear";
  @SerializedName(SERIALIZED_NAME_START_YEAR)
  private Integer startYear;

  public static final String SERIALIZED_NAME_END_YEAR = "endYear";
  @SerializedName(SERIALIZED_NAME_END_YEAR)
  private Integer endYear;

  public static final String SERIALIZED_NAME_CITABLE_ITEMS = "citableItems";
  @SerializedName(SERIALIZED_NAME_CITABLE_ITEMS)
  private JournalProfileCitableItems citableItems;

  public static final String SERIALIZED_NAME_CITATIONS = "citations";
  @SerializedName(SERIALIZED_NAME_CITATIONS)
  private JournalProfileCitations citations;

  public static final String SERIALIZED_NAME_OCCURRENCE_COUNTRIES = "occurrenceCountries";
  @SerializedName(SERIALIZED_NAME_OCCURRENCE_COUNTRIES)
  private List<JournalProfileOccurrenceCountries> occurrenceCountries = null;

  public static final String SERIALIZED_NAME_OCCURRENCE_ORGANIZATIONS = "occurrenceOrganizations";
  @SerializedName(SERIALIZED_NAME_OCCURRENCE_ORGANIZATIONS)
  private List<JournalProfileOccurrenceOrganizations> occurrenceOrganizations = null;

  public JournalProfile() { 
  }

  public JournalProfile startYear(Integer startYear) {
    
    this.startYear = startYear;
    return this;
  }

   /**
   * First year of the profile
   * @return startYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "First year of the profile")

  public Integer getStartYear() {
    return startYear;
  }


  public void setStartYear(Integer startYear) {
    this.startYear = startYear;
  }


  public JournalProfile endYear(Integer endYear) {
    
    this.endYear = endYear;
    return this;
  }

   /**
   * Last year of the profile (equal to the Report year)
   * @return endYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Last year of the profile (equal to the Report year)")

  public Integer getEndYear() {
    return endYear;
  }


  public void setEndYear(Integer endYear) {
    this.endYear = endYear;
  }


  public JournalProfile citableItems(JournalProfileCitableItems citableItems) {
    
    this.citableItems = citableItems;
    return this;
  }

   /**
   * Get citableItems
   * @return citableItems
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public JournalProfileCitableItems getCitableItems() {
    return citableItems;
  }


  public void setCitableItems(JournalProfileCitableItems citableItems) {
    this.citableItems = citableItems;
  }


  public JournalProfile citations(JournalProfileCitations citations) {
    
    this.citations = citations;
    return this;
  }

   /**
   * Get citations
   * @return citations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public JournalProfileCitations getCitations() {
    return citations;
  }


  public void setCitations(JournalProfileCitations citations) {
    this.citations = citations;
  }


  public JournalProfile occurrenceCountries(List<JournalProfileOccurrenceCountries> occurrenceCountries) {
    
    this.occurrenceCountries = occurrenceCountries;
    return this;
  }

  public JournalProfile addOccurrenceCountriesItem(JournalProfileOccurrenceCountries occurrenceCountriesItem) {
    if (this.occurrenceCountries == null) {
      this.occurrenceCountries = new ArrayList<JournalProfileOccurrenceCountries>();
    }
    this.occurrenceCountries.add(occurrenceCountriesItem);
    return this;
  }

   /**
   * Information about of the top 10 countries and regions that have published materials in this journal in the past three years.
   * @return occurrenceCountries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Information about of the top 10 countries and regions that have published materials in this journal in the past three years.")

  public List<JournalProfileOccurrenceCountries> getOccurrenceCountries() {
    return occurrenceCountries;
  }


  public void setOccurrenceCountries(List<JournalProfileOccurrenceCountries> occurrenceCountries) {
    this.occurrenceCountries = occurrenceCountries;
  }


  public JournalProfile occurrenceOrganizations(List<JournalProfileOccurrenceOrganizations> occurrenceOrganizations) {
    
    this.occurrenceOrganizations = occurrenceOrganizations;
    return this;
  }

  public JournalProfile addOccurrenceOrganizationsItem(JournalProfileOccurrenceOrganizations occurrenceOrganizationsItem) {
    if (this.occurrenceOrganizations == null) {
      this.occurrenceOrganizations = new ArrayList<JournalProfileOccurrenceOrganizations>();
    }
    this.occurrenceOrganizations.add(occurrenceOrganizationsItem);
    return this;
  }

   /**
   * Information about of the top 10 organizations that have published materials in this journal in the past three years.
   * @return occurrenceOrganizations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Information about of the top 10 organizations that have published materials in this journal in the past three years.")

  public List<JournalProfileOccurrenceOrganizations> getOccurrenceOrganizations() {
    return occurrenceOrganizations;
  }


  public void setOccurrenceOrganizations(List<JournalProfileOccurrenceOrganizations> occurrenceOrganizations) {
    this.occurrenceOrganizations = occurrenceOrganizations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JournalProfile journalProfile = (JournalProfile) o;
    return Objects.equals(this.startYear, journalProfile.startYear) &&
        Objects.equals(this.endYear, journalProfile.endYear) &&
        Objects.equals(this.citableItems, journalProfile.citableItems) &&
        Objects.equals(this.citations, journalProfile.citations) &&
        Objects.equals(this.occurrenceCountries, journalProfile.occurrenceCountries) &&
        Objects.equals(this.occurrenceOrganizations, journalProfile.occurrenceOrganizations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startYear, endYear, citableItems, citations, occurrenceCountries, occurrenceOrganizations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JournalProfile {\n");
    sb.append("    startYear: ").append(toIndentedString(startYear)).append("\n");
    sb.append("    endYear: ").append(toIndentedString(endYear)).append("\n");
    sb.append("    citableItems: ").append(toIndentedString(citableItems)).append("\n");
    sb.append("    citations: ").append(toIndentedString(citations)).append("\n");
    sb.append("    occurrenceCountries: ").append(toIndentedString(occurrenceCountries)).append("\n");
    sb.append("    occurrenceOrganizations: ").append(toIndentedString(occurrenceOrganizations)).append("\n");
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

