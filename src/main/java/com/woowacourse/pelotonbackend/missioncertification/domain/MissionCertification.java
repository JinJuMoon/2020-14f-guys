package com.woowacourse.pelotonbackend.missioncertification.domain;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Embedded;

import com.woowacourse.pelotonbackend.mission.domain.Mission;
import com.woowacourse.pelotonbackend.rider.domain.Rider;
import com.woowacourse.pelotonbackend.vo.ImageUrl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.With;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@EqualsAndHashCode(of = "id")
@Getter
public class MissionCertification {
    @Id @With(value = AccessLevel.PACKAGE)
    private final Long id;

    @NotNull
    private final MissionCertificationStatus status;

    private final String description;

    @Embedded.Empty
    @Valid
    private final ImageUrl image;

    private final AggregateReference<Rider, @NotNull Long> riderId;

    private final AggregateReference<Mission, @NotNull Long> missionId;

    @CreatedDate
    @PastOrPresent
    private LocalDateTime createdAt;

    @LastModifiedDate
    @PastOrPresent
    private LocalDateTime updatedAt;
}
