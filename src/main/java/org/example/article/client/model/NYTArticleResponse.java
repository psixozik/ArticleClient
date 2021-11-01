package org.example.article.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class NYTArticleResponse {

    public String copyright;
    public Response response;

    @Data
    public static class Legacy{
        public String xlarge;
        public int xlargewidth;
        public int xlargeheight;
        public String thumbnail;
        public int thumbnailwidth;
        public int thumbnailheight;
    }

    @Data
    public static class Multimedia{
        public int rank;
        public String subtype;
        public Object caption;
        public Object credit;
        public String type;
        public String url;
        public int height;
        public int width;
        public String subType;
        public String crop_name;
        public Legacy legacy;
    }

    @Data
    public static class Headline{
        public String main;
        public String kicker;
        public Object content_kicker;
        public String print_headline;
        public Object name;
        public Object seo;
        public Object sub;
    }

    @Data
    public static class Keyword{
        public String name;
        public String value;
        public int rank;
        public String major;
    }

    @Data
    public static class Person{
        public String firstname;
        public String middlename;
        public String lastname;
        public Object qualifier;
        public Object title;
        public String role;
        public String organization;
        public int rank;
    }

    @Data
    public static class Byline{
        public String original;
        public List<Person> person;
        public String organization;
    }

    @Data
    public static class Doc{

        @JsonProperty("abstract") public String abStract;
        public String web_url;
        public String snippet;
        public String lead_paragraph;
        public String source;
        public List<Multimedia> multimedia;
        public Headline headline;
        public List<Keyword> keywords;
        public Date pub_date;
        public String document_type;
        public String news_desk;
        public String section_name;
        public Byline byline;
        public String type_of_material;
        public String _id;
        public int word_count;
        public String uri;
        public String print_section;
        public String print_page;
        public String subsection_name;
    }

    @Data
    public static class Meta{
        public int hits;
    }

    @Data
    public static class Response{
        public List<Doc> docs;
        public Meta meta;
    }
}
