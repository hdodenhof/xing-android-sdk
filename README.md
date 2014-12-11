# XING Android SDK

An Android SDK for accessing the XING API.

*WARNING: this is still under heavy development!*

## Getting Started

* Create an app for the XING API at the [XING Ceveloper Center](https://dev.xing.com/applications) to obtain a consumer key and consumer secret. During the registration process set the OAuth callback domain to `xingapi://callback`.
* Add a dependency to this SDK to your app project - see below for details.
* Access the XING API by creating a new `XingApiClient` with your consumer key and consumer secret.
* Have a look at the included sample application for details.

## Gradle

```
dependencies {
    ...
    compile 'de.hdodenhof:xing-android-sdk:1.0.0-SNAPSHOT'
}
```

## Note

This is not an official product of XING AG, please do not contact them with any issues you might have.

## License

    Copyright 2014 Henning Dodenhof

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
