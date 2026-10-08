$ErrorActionPreference = 'Stop'

$projectRoot = $PSScriptRoot
$profilePath = [Environment]::GetFolderPath([Environment+SpecialFolder]::UserProfile)
$repositoryPath = Join-Path $profilePath '.m2\repository'

if (-not (Get-Command javac -ErrorAction SilentlyContinue)) {
    throw 'A JDK is required. Install Java 17 or newer so both java and javac are available.'
}
if (-not (Test-Path $repositoryPath)) {
    throw "Maven dependencies were not found in $repositoryPath. This script uses cached dependencies and does not download them."
}

$mavenCommand = Get-Command mvn.cmd -ErrorAction SilentlyContinue
$mavenPath = if ($mavenCommand) { $mavenCommand.Source } else { Join-Path $projectRoot 'mvnw.cmd' }

Push-Location $projectRoot
try {
    Write-Host 'Starting the app with Maven (press Ctrl+C to stop).'
    & $mavenPath -o "-Dmaven.repo.local=$repositoryPath" '-Dspring-boot.run.main-class=com.csit321g2.galo_crud.DemoApplication' spring-boot:run
    if ($LASTEXITCODE -ne 0) {
        throw "The app exited with code $LASTEXITCODE."
    }
}
finally {
    Pop-Location
}
