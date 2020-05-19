package edu.cityuniversity.warharness.service.handler;

/**
 * @author rajarar
 */
public class Response {

    private final String contentType;
    private final String payload;

    private Response(String contentType, String payload) {
        this.contentType = contentType;
        this.payload = payload;
    }

    public String contentType() {
        return contentType;
    }

    public String payload() {
        return payload;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {

        private String contentType;
        private String payload;

        public Builder withContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder withPayload(String payload) {
            this.payload = payload;
            return this;
        }

        public Response build() {
            return new Response(this.contentType, this.payload);
        }
    }
}
