package com.woowacourse.pelotonbackend.certification.presentation.dto;

import java.beans.ConstructorProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jdbc.core.mapping.AggregateReference;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.woowacourse.pelotonbackend.certification.domain.Certification;
import com.woowacourse.pelotonbackend.certification.domain.CertificationStatus;
import com.woowacourse.pelotonbackend.vo.ImageUrl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(onConstructor_ = @ConstructorProperties({"status", "description",
    "riderId", "missionId"}))
@Builder
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CertificationCreateRequest {
    @NotNull
    private final CertificationStatus status;

    @NotBlank
    private final String description;

    @NotNull
    private final Long riderId;

    @NotNull
    private final Long missionId;

    public Certification toCertification(final String imageUrl) {
        return Certification.builder()
            .status(this.status)
            .description(this.description)
            .riderId(AggregateReference.to(this.riderId))
            .missionId(AggregateReference.to(this.missionId))
            .image(new ImageUrl(imageUrl))
            .build();
    }
}