package com.example.resumeederpadilla.model

data class GetResumeResponse(
	val skills: List<SkillsItem>,
	val name: String,
	val position: String,
	val experience: List<ExperienceItem>
)
