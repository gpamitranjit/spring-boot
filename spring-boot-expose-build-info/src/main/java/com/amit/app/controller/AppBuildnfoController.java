package com.amit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.AppVersion;

/**
 *
 * @author Amit Patil
 *
 **/
@RestController
@RequestMapping("/v1")
public class AppBuildnfoController {

	@Autowired
	private BuildProperties buildProperties;

	@RequestMapping("/app/buildinfo")
	public ResponseEntity<BuildProperties> retrieveBuildInformation() {
		return new ResponseEntity<BuildProperties>(buildProperties, HttpStatus.OK);
	}

	@RequestMapping("/app/version")
	public ResponseEntity<AppVersion> retrieveAppVersion() {
		return new ResponseEntity<AppVersion>(new AppVersion(buildProperties.getVersion()), HttpStatus.OK);
	}
}
