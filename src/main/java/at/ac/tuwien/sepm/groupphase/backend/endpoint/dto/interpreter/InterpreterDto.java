package at.ac.tuwien.sepm.groupphase.backend.endpoint.dto.interpreter;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InterpreterDto {



	    private Long id;

	    private boolean location_online;

	    private Boolean certificate;

	    private String bankDetails;

	    private String[] topic_knowledge;
}
