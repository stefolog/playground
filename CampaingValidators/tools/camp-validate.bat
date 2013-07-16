@ECHO OFF

REM === Common variables ===
SET CAMPS_ROOT=D:/projects/playground/camp

IF "%1"=="" GOTO ASK_FOR_CAMPAIGN
GOTO SET_CAMPAIGN

:ASK_FOR_CAMPAIGN
SET /P TARGET="Enter the campaign path: "
GOTO VALIDATION
:SET_CAMPAIGN
SET TARGET=%1
GOTO VALIDATION

:VALIDATION
REM === Internal variables ===
SET CAMP_FOLDER=%CAMPS_ROOT%/%TARGET%
SET VALIDATOR=%CAMPS_ROOT%/validator/validate.groovy
SET CP=%CAMPS_ROOT%/validator;%CAMPS_ROOT%/validator/externalAPI.jar;%CAMP_FOLDER%

groovy -cp %CP% %VALIDATOR% %CAMP_FOLDER%
