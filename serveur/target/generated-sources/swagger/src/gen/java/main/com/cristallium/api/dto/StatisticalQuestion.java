package com.cristallium.api.dto;

import java.util.Objects;
import com.cristallium.api.dto.StatisticalAnswer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * StatisticalQuestion
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:05:49.733+01:00")

public class StatisticalQuestion   {
  private Long id = null;

  private String body = null;

  private List<StatisticalAnswer> answers = new ArrayList<StatisticalAnswer>();

  private Boolean closed = null;

  public StatisticalQuestion id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public StatisticalQuestion body(String body) {
    this.body = body;
    return this;
  }

   /**
   * Get body
   * @return body
  **/
  @ApiModelProperty(required = true, value = "")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public StatisticalQuestion answers(List<StatisticalAnswer> answers) {
    this.answers = answers;
    return this;
  }

  public StatisticalQuestion addAnswersItem(StatisticalAnswer answersItem) {
    this.answers.add(answersItem);
    return this;
  }

   /**
   * Get answers
   * @return answers
  **/
  @ApiModelProperty(required = true, value = "")
  public List<StatisticalAnswer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<StatisticalAnswer> answers) {
    this.answers = answers;
  }

  public StatisticalQuestion closed(Boolean closed) {
    this.closed = closed;
    return this;
  }

   /**
   * Get closed
   * @return closed
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean getClosed() {
    return closed;
  }

  public void setClosed(Boolean closed) {
    this.closed = closed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatisticalQuestion statisticalQuestion = (StatisticalQuestion) o;
    return Objects.equals(this.id, statisticalQuestion.id) &&
        Objects.equals(this.body, statisticalQuestion.body) &&
        Objects.equals(this.answers, statisticalQuestion.answers) &&
        Objects.equals(this.closed, statisticalQuestion.closed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, body, answers, closed);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatisticalQuestion {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
    sb.append("    closed: ").append(toIndentedString(closed)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

