# Java CFrame

A Java implementation of Roblox-inspired `CFrame` transformations for working with 3D positions and orientations. Designed for applications such as robotics, coordinate transformations, and 3D simulations.

## Features

- 3D vectors with `Vector3`
- Position and rotation stored in `CFrame`
- Transforming relative coordinate frames into world space with `toWorldSpace()`
- Transforming world-space coordinate frames into local space with `toObjectSpace()`
- Vector rotation around the X, Y, and Z axes

## Getting Started

1. Download or clone this repository.
2. Open the project in your Java IDE.
3. Run the example program to see the transformations in action.

## Example

```java
CFrame base = new CFrame(
    0, 0, 0,
    0, Math.toRadians(90), 0
);

CFrame firstJoint =
    base.toWorldSpace(new CFrame(0, 0, -2));

CFrame secondJoint =
    firstJoint.toWorldSpace(new CFrame(0, 0, -3));

CFrame tool =
    secondJoint.toWorldSpace(new CFrame(0, 0, -1));
```

This example calculates the positions of successive robot-arm joints using relative transformations.

## Example Output

```text
First joint:  -2.0, 0.0, 0.0
Second joint: -5.0, 0.0, 0.0
Tool:         -6.0, 0.0, 0.0
```

## Requirements

- Java 17

## Status

This project is complete

## License

