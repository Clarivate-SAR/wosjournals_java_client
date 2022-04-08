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
import com.clarivate.wos.journals.client.model.CategoryData;
import com.clarivate.wos.journals.client.model.CategoryReportsJournals;
import com.clarivate.wos.journals.client.model.CategoryReportsSourceData;
import com.clarivate.wos.journals.client.model.Frequency;
import com.clarivate.wos.journals.client.model.HalfLife;
import com.clarivate.wos.journals.client.model.Immediacy;
import com.clarivate.wos.journals.client.model.Jif;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CategoryReports
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-04-08T14:37:40.089+02:00[Europe/Paris]")
public class CategoryReports {
  public static final String SERIALIZED_NAME_YEAR = "year";
  @SerializedName(SERIALIZED_NAME_YEAR)
  private Integer year;

  public static final String SERIALIZED_NAME_JOURNALS = "journals";
  @SerializedName(SERIALIZED_NAME_JOURNALS)
  private CategoryReportsJournals journals;

  public static final String SERIALIZED_NAME_ARTICLES = "articles";
  @SerializedName(SERIALIZED_NAME_ARTICLES)
  private Integer articles;

  public static final String SERIALIZED_NAME_CITES = "cites";
  @SerializedName(SERIALIZED_NAME_CITES)
  private Integer cites;

  public static final String SERIALIZED_NAME_JIF = "jif";
  @SerializedName(SERIALIZED_NAME_JIF)
  private Jif jif;

  public static final String SERIALIZED_NAME_IMMEDIACY = "immediacy";
  @SerializedName(SERIALIZED_NAME_IMMEDIACY)
  private Immediacy immediacy;

  public static final String SERIALIZED_NAME_HALF_LIFE = "halfLife";
  @SerializedName(SERIALIZED_NAME_HALF_LIFE)
  private HalfLife halfLife;

  public static final String SERIALIZED_NAME_FREQUENCY = "frequency";
  @SerializedName(SERIALIZED_NAME_FREQUENCY)
  private Frequency frequency;

  public static final String SERIALIZED_NAME_SOURCE_DATA = "sourceData";
  @SerializedName(SERIALIZED_NAME_SOURCE_DATA)
  private CategoryReportsSourceData sourceData;

  public static final String SERIALIZED_NAME_CATEGORY_DATA = "categoryData";
  @SerializedName(SERIALIZED_NAME_CATEGORY_DATA)
  private CategoryData categoryData;

  public CategoryReports() { 
  }

  public CategoryReports year(Integer year) {
    
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public Integer getYear() {
    return year;
  }


  public void setYear(Integer year) {
    this.year = year;
  }


  public CategoryReports journals(CategoryReportsJournals journals) {
    
    this.journals = journals;
    return this;
  }

   /**
   * Get journals
   * @return journals
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CategoryReportsJournals getJournals() {
    return journals;
  }


  public void setJournals(CategoryReportsJournals journals) {
    this.journals = journals;
  }


  public CategoryReports articles(Integer articles) {
    
    this.articles = articles;
    return this;
  }

   /**
   * Get articles
   * @return articles
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getArticles() {
    return articles;
  }


  public void setArticles(Integer articles) {
    this.articles = articles;
  }


  public CategoryReports cites(Integer cites) {
    
    this.cites = cites;
    return this;
  }

   /**
   * Get cites
   * @return cites
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getCites() {
    return cites;
  }


  public void setCites(Integer cites) {
    this.cites = cites;
  }


  public CategoryReports jif(Jif jif) {
    
    this.jif = jif;
    return this;
  }

   /**
   * Get jif
   * @return jif
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Jif getJif() {
    return jif;
  }


  public void setJif(Jif jif) {
    this.jif = jif;
  }


  public CategoryReports immediacy(Immediacy immediacy) {
    
    this.immediacy = immediacy;
    return this;
  }

   /**
   * Get immediacy
   * @return immediacy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Immediacy getImmediacy() {
    return immediacy;
  }


  public void setImmediacy(Immediacy immediacy) {
    this.immediacy = immediacy;
  }


  public CategoryReports halfLife(HalfLife halfLife) {
    
    this.halfLife = halfLife;
    return this;
  }

   /**
   * Get halfLife
   * @return halfLife
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public HalfLife getHalfLife() {
    return halfLife;
  }


  public void setHalfLife(HalfLife halfLife) {
    this.halfLife = halfLife;
  }


  public CategoryReports frequency(Frequency frequency) {
    
    this.frequency = frequency;
    return this;
  }

   /**
   * Get frequency
   * @return frequency
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Frequency getFrequency() {
    return frequency;
  }


  public void setFrequency(Frequency frequency) {
    this.frequency = frequency;
  }


  public CategoryReports sourceData(CategoryReportsSourceData sourceData) {
    
    this.sourceData = sourceData;
    return this;
  }

   /**
   * Get sourceData
   * @return sourceData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CategoryReportsSourceData getSourceData() {
    return sourceData;
  }


  public void setSourceData(CategoryReportsSourceData sourceData) {
    this.sourceData = sourceData;
  }


  public CategoryReports categoryData(CategoryData categoryData) {
    
    this.categoryData = categoryData;
    return this;
  }

   /**
   * Get categoryData
   * @return categoryData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public CategoryData getCategoryData() {
    return categoryData;
  }


  public void setCategoryData(CategoryData categoryData) {
    this.categoryData = categoryData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryReports categoryReports = (CategoryReports) o;
    return Objects.equals(this.year, categoryReports.year) &&
        Objects.equals(this.journals, categoryReports.journals) &&
        Objects.equals(this.articles, categoryReports.articles) &&
        Objects.equals(this.cites, categoryReports.cites) &&
        Objects.equals(this.jif, categoryReports.jif) &&
        Objects.equals(this.immediacy, categoryReports.immediacy) &&
        Objects.equals(this.halfLife, categoryReports.halfLife) &&
        Objects.equals(this.frequency, categoryReports.frequency) &&
        Objects.equals(this.sourceData, categoryReports.sourceData) &&
        Objects.equals(this.categoryData, categoryReports.categoryData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, journals, articles, cites, jif, immediacy, halfLife, frequency, sourceData, categoryData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryReports {\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    journals: ").append(toIndentedString(journals)).append("\n");
    sb.append("    articles: ").append(toIndentedString(articles)).append("\n");
    sb.append("    cites: ").append(toIndentedString(cites)).append("\n");
    sb.append("    jif: ").append(toIndentedString(jif)).append("\n");
    sb.append("    immediacy: ").append(toIndentedString(immediacy)).append("\n");
    sb.append("    halfLife: ").append(toIndentedString(halfLife)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    sourceData: ").append(toIndentedString(sourceData)).append("\n");
    sb.append("    categoryData: ").append(toIndentedString(categoryData)).append("\n");
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

