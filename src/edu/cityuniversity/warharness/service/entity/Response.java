package edu.cityuniversity.warharness.service.entity;

/**
 *
 */
public class Response {

    private final String contentType;
    private final String payload;
    private final int statusCode;

    private Response(Builder builder) {
        this.contentType = builder.contentType;
        this.payload = builder.payload;
        this.statusCode = builder.statusCode;
    }

    public String contentType() {
        return contentType;
    }

    public String payload() {
        return payload;
    }

    public int statusCode() {
        return statusCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String contentType;
        private String payload;
        private int statusCode;

        public Builder withContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder withPayload(String payload) {
            this.payload = payload;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }
}
