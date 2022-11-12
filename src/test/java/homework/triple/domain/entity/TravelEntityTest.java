package homework.triple.domain.entity;

import static org.assertj.core.api.Assertions.*;

import homework.triple.domain.TravelState;
import homework.triple.domain.exception.CannotUpdateTravelException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TravelEntityTest {

	@DisplayName("여행을 등록하지 않은 유저가 수정할 경우 예외가 발생한다.")
	@Test
	void travel_update_not_writer() {
		String travelName = "서울여행";
		Long memberId = 1L;
		Long cityId = 1L;

		final TravelEntity travelEntity = new TravelEntity(travelName, TravelState.TRAVELING, memberId, cityId);

		Long otherMemberId = 2L;

		assertThatThrownBy(() -> travelEntity.validateWriter(otherMemberId))
			.isInstanceOf(CannotUpdateTravelException.class);
	}

}