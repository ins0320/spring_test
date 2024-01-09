package com.quiz.lesson07.entity;

import java.time.ZonedDateTime;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체 출셕 시 필드 값이 보여진다.
@AllArgsConstructor // 파라미터가 모두 있는 생성자
@NoArgsConstructor // 파라미터가 없는 생성자
@Builder(toBuilder = true) // setter 대신 사용, toBuilder = true: 필드값 변경 허용
@Getter // getter
@Table(name = "recruit") // DB테이블명
@Entity // 이 객체는 엔티티다. (JPA-DB)
public class RecruitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // pk설정
	private int id;

	@Column(name = "companyId")
	private int companyId;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "responsibilities")
	private String responsibilities;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@UpdateTimestamp // createdAt이 null 이어도 현재시간으로 저장
	@Column(name = "createdAt", updatable = false) // update시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp // createdAt이 null 이어도 현재시간으로 저장
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
