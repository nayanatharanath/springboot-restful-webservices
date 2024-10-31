package com.spring_boot.rest_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long user_id;
	private String user_first_name;
	private String user_last_name;
	private String user_email;

}
