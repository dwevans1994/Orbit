import React from 'react';
import { StyleSheet, Text, View, Image, TextInput, Slider } from 'react-native';
import CheckBox from 'react-native-checkbox-heaven';
import Gender from './gender.js'





export default class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = { age: 18, checked: false };
  }



  render() {

    return (
      <View style={[styles.container, { backgroundColor: '#250e36' }]}>
        <View style={{
          position: 'absolute',
          flex: 1,
          top: 80,
        }}>
          <Image source={require('./OrbitFinished.png')} style={{ width: 150, height: 65 }} />
        </View>

        <View >
          <Text style={{ color: 'white', }} > Set age</Text>
        </View>

        <View>

          <Slider
            style={{ width: 300 }}
            step={1}
            minimumValue={18}
            maximumValue={65}
            value={this.state.age}
            onValueChange={val => this.setState({ age: val })}

          />

        </View>
        <View>
          <Text style={{ color: 'white' }}>{this.state.age}</Text>
        </View>

        <Gender />
      </View>

    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
