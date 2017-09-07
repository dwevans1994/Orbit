import React, { Component } from 'react';
import {
  StyleSheet,
  Text,
  View
} from 'react-native';

class App extends Component {
  render(){
    return(
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native + Meteor!
        </Text>
        <Text style={styles.instructions}>
          We will use this soon
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex:1 ,
    justifyContent: 'center',
    alignItems: 'center',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: 'black',
    marginBottom: 5,
  },
});

export default App;
