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


package com.clarivate.wos.wos_journals_client.model;

import java.util.Objects;
import java.util.Arrays;
import com.clarivate.wos.wos_journals_client.model.JournalListRecordRanksJci;
import com.clarivate.wos.wos_journals_client.model.RankQuartileData;
import com.clarivate.wos.wos_journals_client.model.RanksEsiCitations;
import com.clarivate.wos.wos_journals_client.model.RanksJif;
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
 * JCR rank and ESI Total cites. Detailed information could be found on [this page](http://jcr.help.clarivate.com/Content/journal-profile-rank.htm)
 */
@ApiModel(description = "JCR rank and ESI Total cites. Detailed information could be found on [this page](http://jcr.help.clarivate.com/Content/journal-profile-rank.htm)")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-04-08T10:29:02.533+02:00[Europe/Paris]")
public class Ranks {
  public static final String SERIALIZED_NAME_JIF = "jif";
  @SerializedName(SERIALIZED_NAME_JIF)
  private List<RanksJif> jif = null;

  public static final String SERIALIZED_NAME_ARTICLE_INFLUENCE = "articleInfluence";
  @SerializedName(SERIALIZED_NAME_ARTICLE_INFLUENCE)
  private List<RankQuartileData> articleInfluence = null;

  public static final String SERIALIZED_NAME_EIGEN_FACTOR_SCORE = "eigenFactorScore";
  @SerializedName(SERIALIZED_NAME_EIGEN_FACTOR_SCORE)
  private List<RankQuartileData> eigenFactorScore = null;

  public static final String SERIALIZED_NAME_IMMEDIACY_INDEX = "immediacyIndex";
  @SerializedName(SERIALIZED_NAME_IMMEDIACY_INDEX)
  private List<RankQuartileData> immediacyIndex = null;

  public static final String SERIALIZED_NAME_JCI = "jci";
  @SerializedName(SERIALIZED_NAME_JCI)
  private List<JournalListRecordRanksJci> jci = null;

  public static final String SERIALIZED_NAME_ESI_CITATIONS = "esiCitations";
  @SerializedName(SERIALIZED_NAME_ESI_CITATIONS)
  private List<RanksEsiCitations> esiCitations = null;

  public Ranks() { 
  }

  public Ranks jif(List<RanksJif> jif) {
    
    this.jif = jif;
    return this;
  }

  public Ranks addJifItem(RanksJif jifItem) {
    if (this.jif == null) {
      this.jif = new ArrayList<RanksJif>();
    }
    this.jif.add(jifItem);
    return this;
  }

   /**
   * Get jif
   * @return jif
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RanksJif> getJif() {
    return jif;
  }


  public void setJif(List<RanksJif> jif) {
    this.jif = jif;
  }


  public Ranks articleInfluence(List<RankQuartileData> articleInfluence) {
    
    this.articleInfluence = articleInfluence;
    return this;
  }

  public Ranks addArticleInfluenceItem(RankQuartileData articleInfluenceItem) {
    if (this.articleInfluence == null) {
      this.articleInfluence = new ArrayList<RankQuartileData>();
    }
    this.articleInfluence.add(articleInfluenceItem);
    return this;
  }

   /**
   * Get articleInfluence
   * @return articleInfluence
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RankQuartileData> getArticleInfluence() {
    return articleInfluence;
  }


  public void setArticleInfluence(List<RankQuartileData> articleInfluence) {
    this.articleInfluence = articleInfluence;
  }


  public Ranks eigenFactorScore(List<RankQuartileData> eigenFactorScore) {
    
    this.eigenFactorScore = eigenFactorScore;
    return this;
  }

  public Ranks addEigenFactorScoreItem(RankQuartileData eigenFactorScoreItem) {
    if (this.eigenFactorScore == null) {
      this.eigenFactorScore = new ArrayList<RankQuartileData>();
    }
    this.eigenFactorScore.add(eigenFactorScoreItem);
    return this;
  }

   /**
   * Get eigenFactorScore
   * @return eigenFactorScore
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RankQuartileData> getEigenFactorScore() {
    return eigenFactorScore;
  }


  public void setEigenFactorScore(List<RankQuartileData> eigenFactorScore) {
    this.eigenFactorScore = eigenFactorScore;
  }


  public Ranks immediacyIndex(List<RankQuartileData> immediacyIndex) {
    
    this.immediacyIndex = immediacyIndex;
    return this;
  }

  public Ranks addImmediacyIndexItem(RankQuartileData immediacyIndexItem) {
    if (this.immediacyIndex == null) {
      this.immediacyIndex = new ArrayList<RankQuartileData>();
    }
    this.immediacyIndex.add(immediacyIndexItem);
    return this;
  }

   /**
   * Get immediacyIndex
   * @return immediacyIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RankQuartileData> getImmediacyIndex() {
    return immediacyIndex;
  }


  public void setImmediacyIndex(List<RankQuartileData> immediacyIndex) {
    this.immediacyIndex = immediacyIndex;
  }


  public Ranks jci(List<JournalListRecordRanksJci> jci) {
    
    this.jci = jci;
    return this;
  }

  public Ranks addJciItem(JournalListRecordRanksJci jciItem) {
    if (this.jci == null) {
      this.jci = new ArrayList<JournalListRecordRanksJci>();
    }
    this.jci.add(jciItem);
    return this;
  }

   /**
   * Get jci
   * @return jci
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<JournalListRecordRanksJci> getJci() {
    return jci;
  }


  public void setJci(List<JournalListRecordRanksJci> jci) {
    this.jci = jci;
  }


  public Ranks esiCitations(List<RanksEsiCitations> esiCitations) {
    
    this.esiCitations = esiCitations;
    return this;
  }

  public Ranks addEsiCitationsItem(RanksEsiCitations esiCitationsItem) {
    if (this.esiCitations == null) {
      this.esiCitations = new ArrayList<RanksEsiCitations>();
    }
    this.esiCitations.add(esiCitationsItem);
    return this;
  }

   /**
   * Get esiCitations
   * @return esiCitations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RanksEsiCitations> getEsiCitations() {
    return esiCitations;
  }


  public void setEsiCitations(List<RanksEsiCitations> esiCitations) {
    this.esiCitations = esiCitations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ranks ranks = (Ranks) o;
    return Objects.equals(this.jif, ranks.jif) &&
        Objects.equals(this.articleInfluence, ranks.articleInfluence) &&
        Objects.equals(this.eigenFactorScore, ranks.eigenFactorScore) &&
        Objects.equals(this.immediacyIndex, ranks.immediacyIndex) &&
        Objects.equals(this.jci, ranks.jci) &&
        Objects.equals(this.esiCitations, ranks.esiCitations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jif, articleInfluence, eigenFactorScore, immediacyIndex, jci, esiCitations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ranks {\n");
    sb.append("    jif: ").append(toIndentedString(jif)).append("\n");
    sb.append("    articleInfluence: ").append(toIndentedString(articleInfluence)).append("\n");
    sb.append("    eigenFactorScore: ").append(toIndentedString(eigenFactorScore)).append("\n");
    sb.append("    immediacyIndex: ").append(toIndentedString(immediacyIndex)).append("\n");
    sb.append("    jci: ").append(toIndentedString(jci)).append("\n");
    sb.append("    esiCitations: ").append(toIndentedString(esiCitations)).append("\n");
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

