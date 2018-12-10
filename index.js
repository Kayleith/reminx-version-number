/* @flow */

import { NativeModules } from 'react-native';

const { RNVersionNumber } = NativeModules;

const VersionNumber = {
  appVersion: RNVersionNumber && RNVersionNumber.appVersion,
  buildVersion: RNVersionNumber && RNVersionNumber.buildVersion,
  bundleIdentifier: RNVersionNumber && RNVersionNumber.bundleIdentifier,
  basestationAppVersion: RNVersionNumber && RNVersionNumber.basestationAppVersion,
  basestationBuildVersion: RNVersionNumber && RNVersionNumber.basestationBuildVersion,
  basestationBundleIdentifier: RNVersionNumber && RNVersionNumber.basestationBundleIdentifier,
  getVersionName: RNVersionNumber.getVersionName
};

export default VersionNumber;
