package io.github.hillelmed.bitbucket.client.domain.repository;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * The type Web hook.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebHook {

    @Nullable
    private String id;

    @Nullable
    private String name;

    private long createdDate;

    private long updatedDate;

    @Nullable
    private List<EventType> events;

    @Nullable
    private WebHookConfiguration configuration;

    @Nullable
    private String url;

    private boolean active;

    /**
     * The enum Event type.
     */
    @Getter
    public enum EventType {
        /**
         * Repo coment added event type.
         */
        REPO_COMENT_ADDED("repo:comment:added"),
        /**
         * Repo coment edited event type.
         */
        REPO_COMENT_EDITED("repo:comment:edited"),
        /**
         * Repo coment deleted event type.
         */
        REPO_COMENT_DELETED("repo:comment:deleted"),

        /**
         * Repo forked event type.
         */
        REPO_FORKED("repo:forked"),
        /**
         * Repo changed event type.
         */
        REPO_CHANGED("repo:refs_changed"),
        /**
         * Repo modified event type.
         */
        REPO_MODIFIED("repo:modified"),

        /**
         * Pr comment added event type.
         */
        PR_COMMENT_ADDED("pr:comment:added"),
        /**
         * Pr comment edited event type.
         */
        PR_COMMENT_EDITED("pr:comment:edited"),
        /**
         * Pr comment deleted event type.
         */
        PR_COMMENT_DELETED("pr:comment:deleted"),

        /**
         * Pr reviewer update event type.
         */
        PR_REVIEWER_UPDATE("pr:reviewer:updated"),
        /**
         * Pr reviewer unapproved event type.
         */
        PR_REVIEWER_UNAPPROVED("pr:reviewer:unapproved"),
        /**
         * Pr reviewer approved event type.
         */
        PR_REVIEWER_APPROVED("pr:reviewer:approved"),
        /**
         * Pr reviewer needswork event type.
         */
        PR_REVIEWER_NEEDSWORK("pr:reviewer:needs_work"),

        /**
         * Pr deleted event type.
         */
        PR_DELETED("pr:deleted"),
        /**
         * Pr merged event type.
         */
        PR_MERGED("pr:merged"),
        /**
         * Pr modified event type.
         */
        PR_MODIFIED("pr:modified"),
        /**
         * Pr declined event type.
         */
        PR_DECLINED("pr:declined"),
        /**
         * Pr opened event type.
         */
        PR_OPENED("pr:opened"),
        /**
         * Pr from ref updated event type.
         */
        PR_FROM_REF_UPDATED("pr:from_ref_updated");

        private final String apiName;

        EventType(final String apiName) {
            this.apiName = apiName;
        }

        /**
         * Convert value from Api to enum.
         *
         * @param apiName ApiName
         * @return value event type
         */
        public static EventType fromValue(final String apiName) {
            for (final EventType enumType : EventType.values()) {
                if (enumType.getApiName().equals(apiName)) {
                    return enumType;
                }
            }
            throw new IllegalArgumentException("Value " + apiName + " is not a legal EventType type");
        }

        @JsonValue
        private String getApiName() {
            return apiName;
        }

        @Override
        public String toString() {
            return this.getApiName();
        }
    }

}
