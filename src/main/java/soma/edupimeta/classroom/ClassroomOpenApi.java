package soma.edupimeta.classroom;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import soma.edupimeta.classroom.models.CreateClassroomRequest;
import soma.edupimeta.classroom.models.MyClassroomsResponse;
import soma.edupimeta.classroom.service.domain.Classroom;

@Tag(name = "Classroom", description = "Classroom API")
public interface ClassroomOpenApi {

    @Operation(summary = "클래스룸 생성", description = "사용자가 입력한 클래스룸 정보를 DB에 저장하는 API")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "클래스룸 생성이 완료되었습니다.", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<Classroom> createClassroom(@RequestBody CreateClassroomRequest createClassroomRequest);

    @Operation(summary = "클래스룸 조회", description = "사용자 계정에 연관된 클래스룸 조회")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "클래스룸 조회 성공", content = @Content(mediaType = "application/json")),
    })
    ResponseEntity<MyClassroomsResponse> getMyClassrooms(Long accountId);
}
