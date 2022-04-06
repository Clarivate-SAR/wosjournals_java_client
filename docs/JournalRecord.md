

# JournalRecord


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Journal unique identifier |  [optional]
**name** | **String** | Journal title |  [optional]
**jcrTitle** | **String** | Journal JCR abbreviation |  [optional]
**isoTitle** | **String** | Journal title in [ISO format](https://www.issn.org/services/online-services/access-to-the-ltwa/) |  [optional]
**issn** | **String** | Current [ISSN identifier](https://www.issn.org/understanding-the-issn/what-is-an-issn/) |  [optional]
**previousIssn** | **List&lt;String&gt;** | Previously assignled ISSN identifiers |  [optional]
**eIssn** | **String** | (For online journals) [Electronic ISSN](https://www.issn.org/understanding-the-issn/assignment-rules/the-issn-for-electronic-media/) identifier |  [optional]
**publisher** | [**Publisher**](Publisher.md) |  |  [optional]
**frequency** | **Integer** | Number of times per year the journal is published |  [optional]
**firstIssueYear** | **Integer** | First year the journal was published |  [optional]
**language** | **String** | Journal publication language |  [optional]
**openAccess** | [**OpenAccess**](OpenAccess.md) |  |  [optional]
**categories** | [**List&lt;Object&gt;**](Object.md) | List of journal categories with related editions/databases |  [optional]
**journalCitationReports** | [**List&lt;Object&gt;**](Object.md) | List of all available Journal Citation Reports by year |  [optional]



